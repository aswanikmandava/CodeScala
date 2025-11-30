package com.amandava.traits

object TraitDemo extends App {
  // encapsulate and abstract the CRUD operations that deals with the database
  trait ProductDao {
    def addProduct(name: String, price: Double, count: Int): Unit
    def deleteProduct(name: String): Unit
    def updateProduct(name: String, price: Double, count: Int): Unit
    def searchProduct(name: String): String
  }

  // implement trait methods using case class
  case class ShoppingCart() extends ProductDao {
    override def addProduct(name: String, price: Double, count: Int): Unit = println(s"$name added")
    override def deleteProduct(name: String): Unit = println(s"$name added")
    override def updateProduct(name: String, price: Double, count: Int): Unit = println(s"$name updated")
    override def searchProduct(name: String): String = "found"
  }

  // create an object to cart
  // object can refer to Trait type
  val cart: ProductDao = ShoppingCart()
  cart.addProduct("Milk", 6.99, 1)
  cart.addProduct("EggBox", 10.99, 1)
  cart.updateProduct("EggBox", 8.99, 2)
  cart.deleteProduct("EggBox")
  cart.searchProduct("Milk")
}
