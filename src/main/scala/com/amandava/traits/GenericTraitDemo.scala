package com.amandava.traits

object GenericTraitDemo extends App {
  // trait that uses a type parameter
  trait GenericProductDao[T] {
    // methods can use the same type parameter
    def addProduct(product: T): Unit
    def deleteProduct(product: T): Unit
    def updateProduct(product: T): Unit
    def searchProduct(product: T): String
  }

  // create a type case class
  case class GenericShoppingCart[T]() extends GenericProductDao[T] {
    override def addProduct(product: T): Unit = println("added")
    override def deleteProduct(product: T): Unit = println("deleted")
    override def updateProduct(product: T): Unit = println("updated")
    override def searchProduct(product: T): String = "found"
  }

  // create a cart object
  val gCart: GenericProductDao[String] = GenericShoppingCart[String]()
  gCart.addProduct("Milk")
  gCart.updateProduct("Eggs")
  gCart.searchProduct("Eggs")
  gCart.deleteProduct("Eggs")
}
