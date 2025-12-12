package com.amandava.futures
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

object FutureTraverse extends App {
  def checkStock(item: String): Future[Option[Int]] = Future {
    println(s"Checking product $item is in stock ...")
    // simulate processing
    Thread.sleep(1000)
    if (item == "Eggs") Some(3) else None
  }
  // list of future func calls
  val futureList = List(
    checkStock("Milk"),
    checkStock("Eggs"),
    checkStock("Sandwich")
  )
  // convert futures
  val futureTravResult = Future.traverse(futureList) {
    qty => qty.map(sqty => sqty.getOrElse(0))
  }
  futureTravResult.onComplete {
    case Success(res) => println(s"Completed: $res")
    case Failure(e) => println(s"Failed: ${e.getMessage}")
  }
  Thread.sleep(3000)

}
