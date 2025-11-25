package com.amandava.functions

object VarArgFunction extends App {
  // function taking variable number of args
  def printFruits(names: String*): Unit = {
    println(s"List of fruits: ${names.mkString(", ")}")
  }

  // call function
  printFruits("Banana", "Mango", "Orange")
  printFruits("Banana")

  val fruits: List[String] = List("Banana", "Mango", "Orange")
  printFruits(fruits: _*)
}
