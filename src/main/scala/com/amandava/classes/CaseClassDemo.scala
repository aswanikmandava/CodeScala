package com.amandava.classes

object CaseClassDemo extends App {

  case class Pet(name: String, color: String, weight: Option[Double] = None)

  // create an object using case class
  val blackCat = Pet("Cat", "Black", Some(12.30))
  val whiteDog = Pet("Dog", "White")
  val whiteDog2 = Pet("Dog", "White")

  // copy an object and override values
  val grayCat = blackCat.copy(name="Cat", color = "Gray")
  println(grayCat.hashCode())

  // convert an object to string format
  println(s"blackCat object = ${blackCat.toString}")
  println(s"whiteDog weight: ${whiteDog.weight}")

  // two objects are considered equal when all of their field values match
  println(s"blackCat == whiteDog ? ${blackCat == whiteDog}")
  println(s"whiteDog == whiteDog2 ? ${whiteDog.equals(whiteDog2)}")

  println(s"whiteDog hashCode = ${whiteDog.hashCode()}")
  println(s"whiteDog2 hashCode = ${whiteDog2.hashCode()}")
}
