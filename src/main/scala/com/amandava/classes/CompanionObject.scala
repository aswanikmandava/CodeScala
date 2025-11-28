package com.amandava.classes

object CompanionObject extends App {

  class Fruit(name: String, color: String) {
    def printInfo(): Unit = {
      println(s"Name: $name, Color: $color")
    }
  }
  // Companion object
  // same name as class name
  object Fruit {
    def apply(name: String, color: String): Fruit = {
      new Fruit(name, color)
    }
  }

  // instantiate Fruit class using companion object
  val apple = Fruit("Simla", "Red")
  apple.printInfo()

}
