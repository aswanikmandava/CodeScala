package com.amandava.futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration._


object FlatMapDemo extends App {
  // define a method that returns a future
  def checkStock(p: String): Future[Int] = Future {
    println(s"checking inventory for $p")
    5
  }
  // define another method that returns a future
  // this takes the  the result from previous method as input parameter
  def buyItems(count: Int): Future[Boolean] = Future {
    println(s"buying quantity: $count")
    true
  }

  // use flatMap() to sequence multiple futures in order
  val buyOutcome: Future[Boolean] = checkStock("Eggs").flatMap(cnt => buyItems(cnt))
  val isSuccess = Await.result(buyOutcome, 3.seconds)
  println(s"Order successful: $isSuccess")

  // use for comprehension to achieve the same
  println("Chaining futures using for comprehension ...")
  for {
    count <- checkStock("Milk")
    orderSuccess <- buyItems(count)
  } yield println(s"Buying milk was successful: $orderSuccess")
  Thread.sleep(2000)
}
