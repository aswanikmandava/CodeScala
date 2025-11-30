package com.amandava.collections

object VectorDemo extends App {
  val myItems: Seq[String] = Vector("Laptop", "Mobile", "Charger")

  // access 1st, 2nd item
  println(s"1st item: ${myItems.head}, 2nd item: ${myItems(1)}")

  // prepend an item
  val myItems2 = "Desktop" +: myItems
  // append an item
  val myItems3 = myItems :+ "Case"
  println(myItems2)
  println(myItems3)

  // concatenate vectors
  val allItems = myItems ++ myItems2
  println(allItems)

  // transform vector elements by converting the case to upper
  val myUppercaseItems = myItems.map(i => i.toUpperCase)
  // use shorter syntax
  val myUppercaseItems2 = myItems.map(_.toUpperCase)
  println(myUppercaseItems)
  println(myUppercaseItems2)
}
