package com.amandava.actor
import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern._
import akka.util.Timeout

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object AskPattern extends App {
  case object GetName
  case class NameResponse(name: String)

  class AskActor(name: String) extends Actor {
    override def receive: Receive = {
      case GetName =>
        println("Asking for name:")
        sender ! NameResponse(name)
    }
  }
  object AskActor {
    def props(name: String) = Props(new AskActor(name))
  }

  val mySystem = ActorSystem("AskSystem")
  val actor1 = mySystem.actorOf(AskActor.props("Aswani"), "AskActor")
  // timeout will be applied implicitly where applicable
  implicit val timeout = Timeout(3.seconds)
  // ask actor
  // response is a future
  val response: Future[Any] = actor1 ? GetName
  response.onComplete {
    case Success(NameResponse(n)) => println(s"Got name: $n")
    case Failure(e) => println(s"Failure: ${e.getMessage}")
  }
  Thread.sleep(2000)
  // this may terminate the system before the future completes
  mySystem.terminate()
}
