package com.amandava.actor

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import akka.pattern._
import akka.util.Timeout

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

object AskPattern_mapTo extends App {
  implicit val timeout: Timeout = Timeout(3.seconds)
  case class Info(name: String)
  // create product info actor
  class ProductInfo extends Actor with ActorLogging {
    override def receive: Receive = {
      case Info(n) if n.contains("Eggs") || n.contains("Milk") =>
        log.info(s"Found $n")
        sender() ! true
      case _ =>
        log.info("Unknown message")
        sender() ! false
    }
  }

  val mySystem = ActorSystem("MySystem")
  val myActor = mySystem.actorOf(Props[ProductInfo], "MyActor")

  // we can map the return type from the actor to a specific type
  val actorResponseFuture: Future[Boolean] = (myActor ? Info("VitalFarms Eggs")).mapTo[Boolean]

  // retrieve the result from future
  for {
    resp <- actorResponseFuture
  } yield println(s"Response from actor: $resp")

  Thread.sleep(4000)
  mySystem.terminate()
}
