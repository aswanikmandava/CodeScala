package com.amandava.functions

object VarArgFunction extends App {
  // function taking variable number of args
  def printItems(names: String*): Unit = {
    println(s"List of items: ${names.mkString(", ")}")
  }

  // call function
  printItems("Banana", "Mango", "Orange")
  printItems("Banana")

  val fruits: List[String] = List("Banana", "Mango", "Orange")
  // pass a list to the function that takes variable number of args
  // the following way
  printItems(fruits: _*)

  // works the same for Sequence and Array
  val veggies = Seq("Carrot", "Pepper", "Egg Plant")
  printItems(veggies: _*)

  val snacks = Array("snack-1", "snack-2")
  printItems(snacks: _*)

}
