package com.amandava.futures
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

object FutureSequence extends App {
  def checkStock(item: String): Future[Option[Int]] = Future {
    println(s"Checking product $item is in stock ...")
    // simulate processing
    Thread.sleep(1000)
    if (item == "Eggs") Some(3) else None
  }

  def buyItems(c: Int): Future[Boolean] = Future {
    println(s"buying $c quantity")
    Thread.sleep(1500)
    if (c > 0) true else false
  }

  def finishOrder(): Future[Unit] = Future {
    println(s"Finishing order ...")
    Thread.sleep(1000)
  }

  // combine future function calls into an immutable list
  val futureList: List[Future[Any]] = List(checkStock("Eggs"), buyItems(3), finishOrder())

  // run future operation in parallel using Future.sequence()
  val futureListResults = Future.sequence(futureList)
  // collect results
  futureListResults.onComplete {
    case Success(out) => println(s"Future completed: $out")
    case Failure(e) => println(s"Future failed: ${e.getMessage}")
  }
  Thread.sleep(3000)
  // block the main program for sometime
  // this allows us to view future results

}
