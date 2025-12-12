package com.amandava.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object ActorDemo extends App {
  // create an actor class
  class MyActor extends Actor {
    override def receive: Receive = {
      case s: String => println(s"String: $s")
      case i: Int => println(s"Int: $i")
      case _: Any => println(s"Unknown")
    }
    def myFunc:Unit = println("normal method")
  }
  // create an actor system
  val mySystem = ActorSystem("amandava")
  // instantiate an actor inside the actor system
  // get the actor reference
  // actor name must not contain space
  val myActor: ActorRef = mySystem.actorOf(Props[MyActor], "SimpleActor")
  // actor name must be unique
  // send messages to actor
  // <actor_obj> ! <msg>
  myActor ! "Hello, Actor !!!"
  println("Sent 1st msg to actor")
  myActor ! 100
  println("Sent 2nd msg to actor")
  myActor ! 9.99
  println("Sent 3rd msg to actor")

  // actor that takes a constructor arg
  class Pet(name: String) extends Actor {
    override def receive: Receive = {
      case s: String => println(s"$name: received msg - $s")
      case other: Any => println(s"$name: unknown msg - $other")
    }
  }
  // companion object
  object Pet {
    def props(name: String) = Props(new Pet(name))
  }
  val myActor2 = mySystem.actorOf(Pet.props("Aswani"))
  myActor2 ! "Hello"
  myActor2 ! 100

  // shutdown the actor system
  // which will gracefully shutdown the actors recursively
  mySystem.terminate()

}
