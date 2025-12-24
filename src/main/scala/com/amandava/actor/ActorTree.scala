package com.amandava.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.collection.mutable

object ActorTree extends App {
  case object CreateChild
  case object SignalChildren
  case object PrintChild
  // signal a specific child using its path in ActorSystem
  case class SignalChild(c_path: String)
  class ParentActor(name: String) extends Actor {
    private var count = 0
    // create a dynamic array to store actor refs
    private val children = mutable.ArrayBuffer[ActorRef]()
    override def receive: Receive = {
      case CreateChild =>
        // create a new child using the current actor context
        // append actor to array
        children += context.actorOf(Props[ChildActor], s"C-$count")
        count += 1
      case SignalChildren =>
        // send a message to each child using PrintChild structure
        children.foreach(_ ! PrintChild)
      case SignalChild(cpath) =>
        val child = context.system.actorSelection(cpath)
        println(s"Sending msg to a child using path $cpath")
        child ! PrintChild

    }
  }
  object ParentActor {
    def props(name: String) = Props(new ParentActor(name))
  }
  class ChildActor extends Actor {
    override def receive: Receive = {
      case PrintChild => println(self.path)
    }
  }
  var mySystem = ActorSystem("ActorFamily")
  var actor1 = mySystem.actorOf(ParentActor.props("P1"), "P1")
  // create children
  actor1 ! CreateChild
  actor1 ! CreateChild
  actor1 ! SignalChildren
  actor1 ! CreateChild
  actor1 ! SignalChildren
  // send a message to specific child using its path
  actor1 ! SignalChild("/user/P1/C-1")
  // send a message to all child actors under "/user/P1" using wildcard character
  // actor1 ! SignalChild("/user/P1/*")
  // send a message to all actors
  // actor1 ! SignalChild("/user/*")

  Thread.sleep(2000)
  mySystem.terminate()
}
