package com.amandava.classes

object SimpleFruitClass extends App {
  // define a Fruit class
  class Fruit(name: String, color: String) {
    def printInfo(): Unit = {
      println(s"Name: $name, Color: $color")
    }
  }

  // instantiate a class
  val mango = new Fruit("Banginapally", "Yellow")

  // call a method on object
  // get info on the mango
  // paranthesis after method is optional
  mango.printInfo
}
