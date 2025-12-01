package com.amandava.collections

import scala.collection.immutable.Queue

object QueueDemo extends App {

  val countries = Queue("India", "Sri Lanka", "Nepal")

  // access the element at specific index
  println(s"2nd element: ${countries(1)}")

  // add an element to the Q
  val countries2 = countries :+ "Bangladesh"
  println(countries2)

  // add an element using enqueue function
  val countries3 = countries.enqueue("Qatar")
  println(countries3)

  // take out the first element from the queue using dequeue
  // returns Tuple2 object (first_element, Rest_of_Q)
  val countries4 = countries3.dequeue
  println(countries4.getClass)
  println(s"first ele: ${countries4._1}, 2nd ele: ${countries4._2}")

  // add a Q to another Q
  val westernCountries = Queue("USA", "Netherlands", "France")
  val asianCountries = Queue("India", "Singapore", "Qatar")
  val allCountries = asianCountries ++ westernCountries
  println(allCountries)
}
