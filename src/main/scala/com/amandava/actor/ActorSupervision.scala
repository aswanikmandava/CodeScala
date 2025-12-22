package com.amandava.actor

import akka.actor.{Actor, ActorRef, ActorSystem, OneForOneStrategy, Props, SupervisorStrategy}
import akka.actor.SupervisorStrategy._

import java.lang
// this is to demo how the supervisor (parent) handles child actor error
// there is a SupervisorStrategy
//  OneForOneStrategy -
//    Handles the individual actor with actions such as
//      Resume (Ignore the error), Stop, Restart (replace with new actor), Escalate
//  OneForAllStrategy
//    Takes action on all child actors
object ActorSupervision extends App {
  case object CreateChild
  case object PrintChild
  case object SignalChildren
  case class SignalChild(c_path: String)
  case class Division(num1: Int, num2: Int)
  case object SomeError
  class ParentActor extends Actor {
    private var index = 0
    private val children = collection.mutable.ArrayBuffer[ActorRef]()
    override val supervisorStrategy: SupervisorStrategy = OneForOneStrategy(loggingEnabled = false) {
      // handle by type of exception or error
      case ae: ArithmeticException =>
        println("Parent caught arithmetic exception; Stopping actor ..")
        // stop the child actor that escalated the error
        Restart
      case se: RuntimeException =>
        println(s"${self.path} Parent: Ignore the error. Continue what you do")
        Resume
      case _: Exception => Restart  // restart the child actor
    }
    override def receive: Receive = {
      case CreateChild =>
        children += context.actorOf(Props[ChildActor], s"Child-$index")
        index += 1
      case SignalChild(path) =>
        // get the specific child actor ref using its path
        val childRef = context.system.actorSelection(path)
        childRef ! PrintChild
      case SignalChildren =>
        children.foreach(_ ! PrintChild)
    }
  }
  class ChildActor extends Actor {
    override val supervisorStrategy: SupervisorStrategy = OneForOneStrategy(loggingEnabled = false) {
      // handle by type of exception or error
      case ae: ArithmeticException =>
        println("Escalating arithmetic exception ..")
        Escalate
      case _: Exception => Restart
    }
    override def receive: Receive = {
      case PrintChild => println(s"${self.path} I've got your msg")
      case Division(n1, n2) =>
        println(s"Got the division task - $n1 / $n2")
        println(n1 / n2)
      case SomeError =>
        println(s"${self.path} Child: Received SomeError")
        // sends this to parent
        throw new RuntimeException("Unknown error")
    }
    override def preStart(): Unit = {
      // acquire any resources before starting an actor
      // such as DB connection, open file etc
      println(s"${self.path} => Starting actor ...")
      super.preStart()
    }

    override def postStop(): Unit = {
      // release resources
      // close DB connection, files etc
      super.postStop()
      println(s"${self.path} => Actor stopped")
    }

  }
  // create an actor system
  val mySystem = ActorSystem("Family")
  val parent = mySystem.actorOf(Props[ParentActor], "Parent")
  parent ! CreateChild
//  parent ! CreateChild
  parent ! SignalChildren
  parent ! SignalChild("/user/Parent/Child-0")
  val child = mySystem.actorSelection("/user/Parent/Child-0")
  child ! SomeError
  child ! Division(1, 0)
  child ! Division(10, 2)
  Thread.sleep(2000)
  mySystem.terminate()
}
