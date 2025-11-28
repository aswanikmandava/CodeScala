package com.amandava.collections

object ListDemo extends App {
  // List is immutable backed by LinkedList. You can't change in place
  // A new list can be created
  val sourFruits = List("Kiwi", "Orange")

  // prepend an item using :: operator to list is fast
  // adding to head is efficient O(1)
  val sourFruits2 = "Pomogranate" :: sourFruits
  println(sourFruits2)

  // append an item using :+ operator to list which is not efficient O(n)
  val fruits = sourFruits2 :+ "Grapes"
  println(fruits)

  // concatenate lists using ++ operator
  val allFruits = sourFruits ++ sourFruits2
  println(allFruits)


}
