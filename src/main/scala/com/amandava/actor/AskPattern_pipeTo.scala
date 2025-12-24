package com.amandava.actor

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.pattern._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import akka.util.Timeout
import scala.util.{Success, Failure}

import scala.concurrent.Future
// pipeTo() can be used to attach to a Future operation by registering the Future and then callback
// to allow you to easily send the result back to the sender
object AskPattern_pipeTo extends App {
  implicit val timeout = Timeout(2.seconds)
  case class Info(name: String)
  case class CheckStock(name: String)
  class ProductInfo extends Actor with ActorLogging {
    override def receive: Receive = {
      case Info(n) if n.contains("Egg") =>
        log.info(s"Received msg: $n")
        sender() ! true
      case _ =>
        log.warning("Received unknown msg")
    }
  }
  class CheckProductStock extends Actor with ActorLogging {
    override def receive: Receive = {
      case CheckStock(n) =>
        log.info(s"Received check stock msg: $n")
        getProductStock(n).pipeTo(sender())
    }
    def getProductStock(name: String): Future[Int] = Future {
      name match {
        case "Eggs" =>
          log.info("Returning Egg stock - 5")
          5
        case "Milk" =>
          log.info("Returning Milk stock - 2")
          2
        case _ => -1
      }
    }
  }

  val mySystem = ActorSystem("amandava")
  val stockActor = mySystem.actorOf(Props[CheckProductStock], "MyStockActor")
  val actorResponse: Future[Int] = (stockActor ? CheckStock("Milk")).mapTo[Int]
//  for {
//    stockResult <- actorResponse
//  } yield println(s"Inventory of Milk: $stockResult")

  actorResponse.map(stockResult => println(s"Inventory of Milk: $stockResult"))
//    1. 	Main thread sends message to actor
//    2. 	Main thread continues immediately
//    3. 	Actor processes message on its own thread
//    4. 	When the actor replies, the Future completes
//    5. 	The callback (println) runs on the execution context
  Thread.sleep(3000)
  mySystem.terminate().onComplete {
    case Success(r) => println("Stopped actor system")
    case Failure(ex) => println(s"Unable to stop actor system: ${ex.getMessage}")
  }

}
