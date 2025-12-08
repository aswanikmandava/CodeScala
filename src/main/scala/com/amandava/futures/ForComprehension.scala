package com.amandava.futures
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._

object ForComprehension extends App {
  // this method returns a future
  // which may return option of some type
  def checkStock(p: String): Future[Option[Int]] = Future {
    println(s"Checking $p is in stock ...")
    if (p == "Egg") Some(3) else None
  }
  // this also returns a future
  def buyItems(c: Int): Future[Boolean] = Future {
    println(s"buying $c quantity")
    if (c > 0) true else false
  }
  println("Chaining future option using for comprehension ...")
  for {
    cnt <- checkStock("Egg")
    isSuccess <- buyItems(cnt.getOrElse(0))
  } yield println(s"Order of milk successful: $isSuccess")

  // you can access the value wrapped inside a Future of Option using the map function
  checkStock("Milk").map(qty => println(s"buying ${qty.getOrElse(0)} count of Milk"))
  Thread.sleep(1000)
}
