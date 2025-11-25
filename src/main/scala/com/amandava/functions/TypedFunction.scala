package com.amandava.functions

// A generic function is a function that takes a type parameter.
// Instead of hardcoding the type (like Int or String), you use a placeholder type (commonly T).
object TypedFunction extends App {
  def getDiscount[T](discount: T): Unit = {
    discount match {
      case value: Int => println(s"Got discount of type int: $value")
      case value: Double => println(s"Got discount of type double: $value")
      case value: String => println(s"Got discount of type string: $value")
      case _ => println(s"Default value")
    }
  }
  // calling the typed function
  // you must provide the type of its parameters
  getDiscount[String]("Umbrella")
  getDiscount[Int](100)
  getDiscount[Double](100.23)
}
