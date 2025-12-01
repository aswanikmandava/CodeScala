package com.amandava.collections
import scala.collection.mutable
import scala.collection.immutable

object MapDemo extends App {
  // Map is available in mutable and immutable forms
  // order of keys are not guaranteed
  var priceMap = mutable.Map("Tomato" -> 5.99, "Potato" -> 2.99, "Spinach" -> 3.99)
  println(priceMap)

  // chaging the key value
  priceMap("Potato") = 2.49
  println(priceMap)

  val veggiePriceMap = immutable.Map("Green Pepper" -> 2.49, "Red Pepper" -> 2.29)
}
