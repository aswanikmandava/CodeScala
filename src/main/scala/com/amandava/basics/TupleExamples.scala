package com.amandava.basics

object TupleExamples extends App {
  val onePair = Tuple2("one", 1)
  println(s"First element: ${onePair._1}, second: ${onePair._2}")

  // fruit color, weight and price
  val mango = ("Green", 1.5f, 3)
  val banana = ("Yellow", 0.6f, 1)
  val kiwi = ("Gray", 0.5f, 2)

  val fruitList = List(mango, banana, kiwi)
  // loop through fruits and pattern match
  val weight = 0.5f
  val price = 2
  // iterate through tuples
  val result = fruitList.foreach {
    item => println(s"one: ${item._1}, two: ${item._2}, three: ${item._3}")
  }
  val result_2 = fruitList.foreach {
    tuple => {
      tuple match {
        case ("Gray", weight, price) => println("Kiwi fruit")
        case _ => println("No match")
      }
    }
  }
  println(s"result_2: $result_2")

}
