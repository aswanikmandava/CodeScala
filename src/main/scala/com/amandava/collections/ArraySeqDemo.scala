package com.amandava.collections

import scala.collection.immutable.ArraySeq


object ArraySeqDemo extends App {
  val myItems = ArraySeq(10, 20, 30, 40)
  // access by index
  println(s"2nd element: ${myItems(1)}")
  // prepend an item
  val myItems2 = 0 +: myItems
  // append an item
  val myItems3 = myItems :+ 50
  println(myItems2)
  println(myItems3)
  // transform each element
  val myTransItems = myItems.map(_ * 2)
  println(myTransItems)
}
