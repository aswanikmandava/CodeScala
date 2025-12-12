package com.amandava.futures

import java.util.concurrent.Executors
import scala.concurrent.{Future, ExecutionContext}
import scala.util.{Success, Failure}

object ExecutionContextDemo extends App {

  // define an execution context
  val executor = Executors.newSingleThreadExecutor()
  implicit val myEC = scala.concurrent.ExecutionContext.fromExecutor(executor)

  // method that returns a Future
  def checkStock(item: String): Future[Int] = Future {
    println("Checking inv count for $item ...")
    Thread.sleep(1000)
    5
  }
  // call the method that return a future
  val myFuture: Future[Int] = checkStock("Eggs")

  // register an onComplete() callback to access the result of future
  myFuture.onComplete {
    case Success(res) => println(s"SUCCESS: $res")
    case Failure(e) => println(s"ERROR: ${e.getMessage}")
  }

  // wait for the task to complete
  Thread.sleep(2000)

  // shutdown the executor
  executor.shutdownNow()

}
