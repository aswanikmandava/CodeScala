package com.amandava.collections

import scala.collection.immutable.ListMap

object ListMapDemo extends App {
  // ListMap is a data structure with a list of key/value pairs
  // key -> value
  val countryCode = ListMap("India" -> "IN", "America" -> "US", "Canada" -> "CN")
  // access specific element value using its key
  // no escaping for double quote required as quotes are part of an expression
  println(s"US: ${countryCode("America")}")

  // add a key
  val countryCode2 = countryCode + ("Australia" -> "AUS")
  println(countryCode2)

  // remove a key
  val countryCode3 = countryCode - ("US")
  println(countryCode3)

  // adding a listmap to another
  val numMap = ListMap("One" -> 1, "Two" -> 2, "Three" -> 3)
  val finalMap = countryCode ++ numMap
  println(finalMap)
}
