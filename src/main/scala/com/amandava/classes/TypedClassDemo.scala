package com.amandava.classes

object TypedClassDemo extends App {

  class Product(name: String, price: Double, count: Int) {
    def getInfo(): Unit = println(s"Name: $name, price: $price")
  }

  // generic (typed) class
  // to take in a Sequence of products
  // restrict class to accept items of type Product class only
  // type restriction operator <:
  class ShoppingCart[P <: Product](items: Seq[P]) {
    def viewCart: Unit = items.foreach(_.getInfo)
  }

  val milk: Product = new Product("Maple Hill", 7.99, 1)
  val eggs: Product = new Product("CountyHill", 10.99, 2)
  val cart: ShoppingCart[Product] = new ShoppingCart[Product](List(milk, eggs))
  println(cart.viewCart)

  // refactor Product as a case class
  case class Productv2(name: String, price: Double, count: Int) {
    def getInfov2: Unit = println(s"Name: $name, price: $price")
  }

  class ShoppingCartv2[T <: Productv2](items: Seq[T]) {
    def viewCart: Unit = items.foreach(_.getInfov2)
  }


  val bananas: Productv2 = Productv2("Costarica Bananas", 2.99, 12)
  val pears: Productv2 = Productv2("Austria Pears", 5.99, 4)
  // print bananas
  println(bananas)
  val cart2:ShoppingCartv2[Productv2] = new ShoppingCartv2[Productv2](List(bananas, pears))
  cart2.viewCart

}
