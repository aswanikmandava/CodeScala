package com.amandava.partial_functions

object PartialFunctionDemo extends App {

  // this partial function only accepts inputs 1 and 100
  val myPartFunc: PartialFunction[Int, String] = {
    case 1 => "One"
    case 100 => "Hundred"
  }

  // define a fallback function (default)
  val myDefaultFunc: PartialFunction[Int, String] = {
    case _ => "Invalid input"
  }
  println(myPartFunc(1))
  println(myPartFunc(100))
  // println(myPartFunc(2)) // this throws scala.MatchError
  // check if the input is defined before calling partial function
  if (myPartFunc.isDefinedAt(2)) myPartFunc(2) else println("Input 2 is not supported")

  // use applyOrElse to define the default value
  val result = myPartFunc.applyOrElse(3, (_: Int) => "Invalid input")
  println(result)

  // another way is to use fallback mechanism by chaining partial functions using "orElse"
  val myPrefFunc = myPartFunc orElse myDefaultFunc
  println(myPrefFunc(1))
  println(myPrefFunc(2))
  println(myPrefFunc(100))

}
