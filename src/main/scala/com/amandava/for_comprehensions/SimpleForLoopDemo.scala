package com.amandava.for_comprehensions

object SimpleForLoopDemo extends App {
  val fruits = List("Mango", "Kiwi", "Grapes", "Guava", "Avocados")
  // loop through the fruits of length more than 4 chars
  for (item <- fruits if item.length > 4) {
    println(s"Filtered fruit: $item")
  }
}
