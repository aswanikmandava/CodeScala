package com.amandava.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object ActorCommunication extends App {
  // this programs demonstrates how one actor can communicate with another
  // to accomplish a task
  case class AssignWork(start: Int, worker: ActorRef)
  case class DoWork(start: Int)
  class Incrementer extends Actor {
    override def receive: Receive = {
      case AssignWork(i, doer) =>
        // self refers to the actor
        println(s"$self - Received $i Calling DoWork(${i+1})")
        doer ! DoWork(i + 1)
      case DoWork(i) =>
        if (i == 10) {
          // get access to ActorSystem using the actor's context
          context.system.terminate()
        } else {
          println(s"DoWork - $self - Received $i Calling DoWork(${i+1})")
          sender ! DoWork(i + 1)
        }
    }
  }
  val actorSystem = ActorSystem("Simple")
  val supervisor = actorSystem.actorOf(Props[Incrementer], "Manager")
  val worker = actorSystem.actorOf(Props[Incrementer], "Worker")
  supervisor ! AssignWork(0, worker)
}
