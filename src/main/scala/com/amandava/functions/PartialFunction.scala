package com.amandava.functions

object PartialFunction extends App {
  // PartialFunction[A, B]
  // takes an input of type A
  // returns an output of type B
  val organicProducts: PartialFunction[String, String] = {
    case "VitalFarms Eggs" | "OrganicValley Eggs" => "Cage Free"
    case "MapleHill Milk" => "Grass Fed"
  }

  val regularProducts: PartialFunction[String, String] = {
    case "Dave's Killer Bread" => "Bread"
    case s if s.contains("Juice") => "Some Juice"
  }

  val unknownProducts: PartialFunction[String, String] = {
    case _ => "Unknown"
  }

  println(s"organicProducts(Milk): ${organicProducts("MapleHill Milk")}")
//  println(s"organicProducts(Milk): ${organicProducts("Milk")}") // gives scala.MatchError

  // compose partial functions using orElse
  val myProducts = organicProducts orElse regularProducts orElse unknownProducts

  println(s"myProducts: ${myProducts("Mango Juice Sliced")}")
  println(s"myProducts: ${myProducts("Dave's Killer Bread")}")
}
