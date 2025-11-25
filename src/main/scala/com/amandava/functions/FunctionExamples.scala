package com.amandava.functions

object FunctionExamples {
  // function with no args
  def sayHello(): Unit = {
    println("Hello")
  }

  // function with args
  // Scala functions implicitly return the value of their last evaluated expression.
  // This is the idiomatic and preferred way to return values in Scala.
  def getFullName(firstName: String, lastName: String): String = {
    firstName + " " + lastName
    // result is implicitly returned
  }

  // function with args using default values
  def getFullNameWithDefault(firstName: String = "UnknownFirst",
                             lastName: String = "UnknownLast"): String = {
    firstName + " " + lastName
  }

  // single line function with args
  def getFullName_v2(firstName: String, lastName: String): String = firstName + " " + lastName

  // higher order function
  // taking another function as an argument
  def getFullNameLength(getName: (String, String) => String): Int = {
    val fullName = getName("Aswani", "Mandava")
    println("Full name: " + fullName)
    fullName.length
  }

  def main(args: Array[String]): Unit = {
    sayHello()
    println(getFullName(firstName = "Aswani", lastName = "Mandava"))
    println(getFullNameWithDefault())
    println(getFullNameWithDefault(firstName = "Aswani"))
    println(getFullNameWithDefault(lastName = "Mandava"))
    println(getFullName_v2("Akshara", "Mandava"))
    println(getFullNameLength(getFullName))


  }
}
