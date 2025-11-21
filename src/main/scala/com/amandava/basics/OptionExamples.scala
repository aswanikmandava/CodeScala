package com.amandava.basics

object OptionExamples extends App {
  def findName(id: Int): Option[String] = {
    if (id == 1) Some("Anamika")
    else None
  }

  println("Calling function with an arg that return some name ...")
  val result1 = findName(1)   // Some("Anamika")
  println(s"result1: $result1")
  println("Calling function with an arg that return nothing ...")
  val result2 = findName(2)   // None
  println(s"result2: $result2")
  val result3 = findName(3).getOrElse("Unknown")
  println(s"result3: $result3")

  // Safe handling with pattern matching
  result1 match {
    case Some(name) => println(s"Found: $name")
    case None       => println("No name found")
  }
}
