package com.amandava.collections

import scala.collection.immutable.HashSet
object HashSetDemo extends App {
  val nuts = HashSet("Almonds", "Cashews", "Pistachios")
  val asianNuts = HashSet("Cashews", "Peanuts")

  // you cannot access element by index
  // however you can check whether an element exists or not
  println(s"Is Cashews in nuts: ${nuts("Cashews")}")
  println(s"Is Almonds in asianNuts: ${asianNuts("Almonds")}")

  // add an element
  val tastyNuts = nuts + "Pine"

  // remove an element
  val result = tastyNuts - "Pine"
  println(result)

  // add a HashSet to another
  val result2 = nuts ++ asianNuts
  println(result2)

  // find common elements using intersection operator &
  val commonResult = nuts & asianNuts
  println(commonResult)

  // find difference between HashSets using &~
  val diffResult = nuts &~ asianNuts
  println(s"difference: $diffResult")
}
