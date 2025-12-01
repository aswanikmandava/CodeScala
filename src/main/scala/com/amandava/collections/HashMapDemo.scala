package com.amandava.collections

import scala.collection.immutable.HashMap

object HashMapDemo extends App {

  // init HashMap using tuples of (key, value)
  val countryCode = HashMap(("America", "US"), ("India", "IN"))
  // init HashMap using key -> value notation
  val numberMap = HashMap("One" -> 1, "Two" -> 2)

  // access a specific key
  println(s"Code of India: ${countryCode("India")}")

  // add a new key
  val countryCode2 = countryCode + ("Australia" -> "AUS")

  // remove an existing key
  val countryCode3 = countryCode - "Australia"
  println(countryCode3)

  // adding a HashMap to another one
  val newMap = countryCode ++ numberMap
  println(newMap)
}
