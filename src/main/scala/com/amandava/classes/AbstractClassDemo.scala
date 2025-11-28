package com.amandava.classes

object AbstractClassDemo extends App {
  abstract class Pet(name: String, color: String) {
    // this will be implemented by sub-classes
    def makeSound(): String
  }
  // sub-class inheriting abstract Pet class
  class Cat(name: String, color: String) extends Pet(name, color) {
    override def makeSound(): String = "meow meow !!!"
  }
  // companion object of Cat
  object Cat {
    def apply(name: String, color: String): Pet = {
      new Cat(name, color)
    }
  }

  val blackCat = Cat(name="snoopy", color = "black")
  println(s"blackCat makes sound: ${blackCat.makeSound()}")

  // case class inheriting abstract Pet class
  case class Dog(name: String, color: String) extends Pet(name, color) {
    override def makeSound(): String = "bow bow !!!"
  }

  // create a Dog object
  val whiteDog = Dog(name="puppy", color="white")
  println(s"whiteCat makes sound: ${whiteDog.makeSound()}")

}
