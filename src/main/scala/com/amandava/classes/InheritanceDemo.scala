package com.amandava.classes

object InheritanceDemo extends App {
  // base class
  class Pet(name: String) {
    private val uuid = 500
    def getPetInfo(): Unit = {
      println(s"Name: $name; Id: $uuid")
    }
  }

  // sub classes
  class Cat(name: String) extends Pet(name)
  class Dog(name: String) extends Pet(name)

  // companion object
  object Pet {
    def apply(name: String): Pet = {
      // instantiate different kinds of pets
      // using pattern matching
//      println("Inside companion object")
      name match {
        case "Cat" => new Cat(name)
        case "Dog" => new Dog(name)
        case _ => new Pet(name)
      }
    }
  }

  val blackCat = Pet("Cat")
  val whiteDog = Pet("Dog")
  println(s"Calling black cat method ...")
  blackCat.getPetInfo()
  whiteDog.getPetInfo()
  println(s"blackCat class: ${blackCat.getClass}")

}
