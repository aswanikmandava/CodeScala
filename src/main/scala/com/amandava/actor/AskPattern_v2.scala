package com.amandava.actor
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern._
import akka.util.Timeout
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object AskPattern_v2 extends App {
  case object GetName
  case class NameResponse(name: String)
  case class AskNameOf(other: ActorRef)

  class AskActor(name: String) extends Actor {
    import context.dispatcher
    implicit val timeout = Timeout(2.seconds)
    override def receive: Receive = {
      case GetName =>
        println("Asking for name:")
        sender ! NameResponse(name)
      case AskNameOf(other) =>
        val f = other ? GetName
        f.onComplete {
          case Success(NameResponse(name)) => println(s"Resp: $name")
          case Success(r) => println(s"No name provided: $r")
          case Failure(e) => println(s"Failure: $e")
        }

    }
  }
  object AskActor {
    def props(name: String) = Props(new AskActor(name))
  }

  val mySystem = ActorSystem("AskSystem")
  val actor1 = mySystem.actorOf(AskActor.props("Rob"), "Rob")
  val actor2 = mySystem.actorOf(AskActor.props("Bob"), "Bob")
  // timeout will be applied implicitly where applicable
  implicit val timeout = Timeout(3.seconds)
  // ask actor
  // response is a future
  val response: Future[Any] = actor1 ? GetName
  response.onComplete {
    case Success(NameResponse(n)) => println(s"Got name: $n")
    case Failure(e) => println(s"Failure: ${e.getMessage}")
  }
  actor1 ! AskNameOf(actor2)
  Thread.sleep(2000)
  // this may terminate the system before the future completes
  mySystem.terminate()
}
