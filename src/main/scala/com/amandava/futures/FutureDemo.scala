package com.amandava.futures

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent._
import scala.util.{Success, Failure}

object FutureDemo extends App {

  def checkStock(item: String): Future[Int] = Future {
    println(s"Checking product $item is in stock ...")
    if (item == "Eggs") {
      Thread.sleep(3.seconds.toMillis)
    } else {
      throw new RuntimeException("Inventory service error")
    }

    1
  }

  // call function that returns a future
  // wait for the result (blocking call)
  // timeout in 3 seconds
  // if the await call takes longer than 3 seconds,
  // Await.result() throws scala.concurrent.TimeoutException
  try {
    val eggs = Await.result(checkStock("Eggs"), 3.seconds)
    println(s"Inventory count for eggs: $eggs")
  } catch {
    // handle exceptions case by case
    case e: TimeoutException => println(s"Inventory check call timedout: ${e.getMessage}")
    // default
    case e: Throwable => println(s"Caught exception: ${e.getMessage}")
  }

  // non-blocking call
  val milk = checkStock("Milk")
  // use Future.onComplete() callback to capture the result of a Future
  milk.onComplete {
    case Success(product) => println(s"Found inventory for milk: $product")
    case Failure(e) => println(s"Inventory check failed for milk: ${e.getMessage}")
  }
  // blocking the main thread so that we can see the result
  Thread.sleep(2000)
}
