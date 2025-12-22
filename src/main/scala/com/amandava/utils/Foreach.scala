package com.amandava.utils

// foreach is a higher‑order method available on collections (List, Seq, Map, Option, etc.).
// It takes a function and applies that function to each element of the collection
// it is used to create side-effects but, not to produce a new collection
object Foreach extends App {
  val numbers: List[Int] = List(10, 11, 12, 13, 14, 15)
  // to add 50 to odd numbers
  // to add 100 to even numbers
  numbers.foreach {
    item => 
      val remainder = item % 2
      if (remainder == 0) {
        println(s"Item: ${item + 100}")
      }
      else {
        println(s"Item: ${item + 50}")
      }
  }
}
