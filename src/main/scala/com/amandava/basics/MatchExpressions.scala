package com.amandava.basics

object MatchExpressions {
  def main(args: Array[String]): Unit = {
    val fruit = "Kiwi"
    val result: Unit = fruit match {
      case "Kiwi" => println("Fruit of NZ")
      case "Dragan" => println("Fruit of China")
      case "Mango" => println("Fruit of India")
      case "Orange" => println("Fruit of US")
      case _ => println("Some default fruit")
    }

    // pattern matching using pipe => logical OR
    // using if condition
    val myFruit = "Star"
    val result2: Unit = myFruit match {
      case "Pomegranate" | "Orange" => println("Citrus fruits")
      case "Star"
        if myFruit.toLowerCase.contains("sta") ||
          myFruit.toLowerCase.contains("mango") => println("Star Fruit")
      case _ => println("Unknown fruit")
    }
  }
}
