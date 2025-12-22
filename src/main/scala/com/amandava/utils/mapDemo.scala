package com.amandava.utils

// map is a higher order function that transforms one collection to another
object mapDemo extends App {
  val numList = List(10, 20, 30, 40, 50)
  val newList = numList.map {
    item => 2 * item
  }
  println(newList)
}
