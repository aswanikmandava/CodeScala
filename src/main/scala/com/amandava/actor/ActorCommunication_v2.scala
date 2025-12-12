package com.amandava.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.amandava.actor.ActorCommunication_v2.{AssignWork, Incrementer}

object ActorCommunication_v2 extends App {
  // this programs demonstrates how one actor can communicate with another
  // to accomplish a task
  case class AssignWork(worker: ActorRef)
  // since there is no parameters, case object can be used instead of case class
  case object DoWork
  case class Completed(isDone: Boolean)
  class Incrementer extends Actor {
    override def receive: Receive = {
      case AssignWork(doer) =>
        // self refers to the actor
        println(s"$self - Received Msg; Calling DoWork()")
        doer ! DoWork
      case Completed(status) =>
        println(s"$self - Work completed? $status. Terminating system ...")
        // get access to ActorSystem using the actor's context
        context.system.terminate()
      case DoWork =>
        println(s"DoWork - $self - Got Msg. Working on it")
        // simulate some work
        Thread.sleep(1000)
        sender ! Completed(true)
    }
  }
  val actorSystem = ActorSystem("Simple")
  val supervisor = actorSystem.actorOf(Props[Incrementer], "Manager")
  val worker = actorSystem.actorOf(Props[Incrementer], "Worker")
  supervisor ! AssignWork(worker)
}
