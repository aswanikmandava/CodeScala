package com.amandava.for_comprehensions

object SimpleForYieldDemo extends App {
  val fruits = List("Mango", "Kiwi", "Grapes", "Guava", "Avocados")
  // loop through the fruits of length more than 4 chars
  // store the items in a new list
  val filteredFruits = for {
    item <- fruits
    // filter condition
    if item.length > 4 ||
      item.toUpperCase.startsWith("MAN") || // toUpperCase() is same as toUpperCase
      item.toUpperCase.endsWith("DOS")
  } yield item

  // print the results
  println(s"Result after filter: $filteredFruits")
}

