package com.amandava.traits

object ClassExtendsMultipleTraits extends App {
  // trait that uses a type parameter
  trait GenericProductDao[T] {
    // methods can use the same type parameter
    def addProduct(product: T): Unit
    def deleteProduct(product: T): Unit
    def updateProduct(product: T): Unit
    def searchProduct(product: T): String
  }
  // trait that uses a type parameter
  trait InventoryDao[T] {
    def getProductStock(product: T): Int
  }

  // case class that extends multiple traits
  case class ShoppingCartv3[T]() extends GenericProductDao[T] with InventoryDao[T] {
    override def addProduct(product: T): Unit = product match {
      case "Milk" => println("Milk added")
      case "EggBox" => println("EggBox added")
      case "Butter" => println("Butter added")
    }
    override def deleteProduct(product: T): Unit = println("deleted")
    override def updateProduct(product: T): Unit = println("updated")
    override def searchProduct(product: T): String = "found"
    override def getProductStock(product: T): Int = product match {
      case "Milk" => 50
      case "EggBox" => 100
      case "Butter" => 20
    }
  }

  // create an cart object
  val cartv3: ShoppingCartv3[String] = ShoppingCartv3[String]()
  cartv3.addProduct("Milk")
  cartv3.addProduct("Butter")
  cartv3.deleteProduct("Butter")
  println(cartv3.getProductStock("EggBox"))
}
