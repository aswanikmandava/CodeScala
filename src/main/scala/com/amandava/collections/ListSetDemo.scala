package com.amandava.collections

import scala.collection.immutable.ListSet

object ListSetDemo extends App {
  val numList = List(1, 2, 5, 5, 6, 6, 8)
  // convert to ListSet by removing duplicates
  val numSet = numList.to(collection.immutable.ListSet)
  println(numSet)

  // check if an element is in a list set
  println(s"Checking if 6 is in list: ${numSet(6)}")
  println(s"Checking if 9 is in list: ${numSet(9)}")

  // add an element to a listset
  val numSet2: ListSet[Int] = numSet + 10
  println(numSet2)

  // remove an element from listset
  val numSet3 = numSet - 6
  println(numSet3)

  val veggiesSet = ListSet("Tomato", "Broccoli", "Potato")

  // adding a ListSet to another one
  val numVeggieSet = numSet ++ veggiesSet
  println(numVeggieSet)
}
