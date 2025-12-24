package com.amandava.functions

import scala.annotation.tailrec

// Tail recursive function will help prevent overflow in your call stack because the evaluation of
// your looping construct happens at each step
object TailRecursive extends App {

  // define an array of type string
  val products: Array[String] = Array("Eggs", "Milk", "Bread", "Juice")

  // define a search function uses recursive approach to find the given product in products array
  @tailrec
  def searchProduct(pName: String, items: Array[String], index: Int): Option[Boolean] = {
    if (index == items.length) {  // end of the array is reached
      None
    } else if (pName == items(index)) {   // when element is found at the current index
      println(s"Found $pName at index $index")
      Some(true)
    } else {
      val nextIndex = index + 1
      println(s"$pName not found at index($index); Recursive call with $nextIndex")
      searchProduct(pName, items, nextIndex)
    }
  }

  // call the search function
  val found = searchProduct("Milk", products, 0)
  println(s"Found: $found")
}
