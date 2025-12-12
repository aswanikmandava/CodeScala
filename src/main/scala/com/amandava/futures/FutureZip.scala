package com.amandava.futures
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}
object FutureZip extends App {
  def checkStock(item: String): Future[Option[Int]] = Future {
    println(s"Checking product $item is in stock ...")
    // simulate processing
    Thread.sleep(1000)
    if (item == "Eggs") Some(3) else None
  }

  def itemPrice(item: String): Future[Double] = Future.successful(6.99)

  // zip the value of both futures
  val combineFutureResult = checkStock("Egg") zip itemPrice("Egg")
  // collect results
  combineFutureResult.onComplete {
    case Success(res) => println(s"Result: $res")
    case Failure(e) => println(s"Result: ${e.getMessage}")
  }
  Thread.sleep(3000)
}
