package com.amandava.futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success, Try}

object PromiseDemo extends App {
  // method that returns a int
  def checkStock(item: String): Int = {
    println(s"Checking the inv count of $item ...")
    Thread.sleep(1000)
    if (item == "Eggs") 5 else throw new IllegalStateException(s"$item out of stock")
    3
  }

  // create a promise of type int
  val itemPromise = Promise[Int]()

  // define a future from promise
  val itemFuture = itemPromise.future

  itemFuture.onComplete {
    case Success(res) => println(s"SUCCESS: $res")
    case Failure(e) => println(s"FAILURE: ${e.getMessage}")
  }

  // use Promise.success to complete the future successfully
  // use Promise.failure to fail the future
//  val itemInfo = "Milk"
//  if (itemInfo == "Eggs") {
//    itemPromise.success(checkStock(itemInfo))
//  } else {
//    itemPromise.failure(Try(checkStock(itemInfo)).failed.get)
//  }

  // you can also use Promise.complete to complete the future
  itemPromise.complete(Try(checkStock("Milk")))

  Thread.sleep(2000)
}
