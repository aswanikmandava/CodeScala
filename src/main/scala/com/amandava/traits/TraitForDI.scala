package com.amandava.traits

// Use trait for Dependency Injection
object TraitForDI extends App {
  // Generic trait that abstracts the backend DB
  trait ProductDB[T] {
    def add(p: T): Unit
    def update(p: T): Unit
    def delete(p: T): Unit
    def query(p: T): String
  }

  // case class that extends trait
  // MongoDB is current storage layer
  case class MongoStorageLayer[T]() extends ProductDB[T] {
    override def add(p: T): Unit = println("added to MongoDB")
    override def update(p: T): Unit = println("updated MongoDB")
    override def delete(p: T): Unit = println("deleted in MongoDB")
    override def query(p: T): String = "found in MongoDB"
  }

  // future storage layer
  case class CassandraStorageLayer[T]() extends ProductDB[T] {
    override def add(p: T): Unit = println("added to Cassandra")
    override def update(p: T): Unit = println("updated Cassandra")
    override def delete(p: T): Unit = println("deleted in Cassandra")
    override def query(p: T): String = "found in Cassandra"
  }

  // trait that defines methods for a data access layer and
  // will require dependency injection for Product DB
  trait ProductDao[T] {
    val product: ProductDB[T]   // dependency injection
    // here we are not attached to the specific implementation of storage layer
    // mongodb in this case
    // we can switch to any other storage layer later on
    def addProduct(item: T): Unit = {
      println("Calling add method on the backend DB")
      product.add(item)
    }

    def updateProduct(item: T): Unit = {
      println("Calling update method on the backend DB")
      product.update(item)
    }

    def deleteProduct(item: T): Unit = {
      println("Calling delete method on the backend DB")
      product.delete(item)
    }

    def searchProduct(item: T): String = {
      println("Calling search method on the backend DB")
      product.query(item)
      "found"
    }
  }

  trait ProductInventoryService[T] {
    val product: ProductDB[T]     // dependency injection
    // concrete method
    // a method with implementation
    def getProductStock(item: T): Int = {
      println("Querying the backend DB ...")
      product.query(item)
      10
    }
  }

  // main trait
  trait ShoppingCartServices[T] extends ProductDao[T] with ProductInventoryService[T] {
    // inject the implementation of storage layer
    // ability to switch to specific implementation

    // mongodb
    override val product: ProductDB[T] = MongoStorageLayer[T]()

    // cassandra
    // override val product: ProductDB[T] = CassandraStorageLayer[T]()
  }

  // main class
  case class ShoppingCart[T]() extends ShoppingCartServices[T]

  // create a cart object
  val cart: ShoppingCart[String] = ShoppingCart[String]()
  cart.addProduct("Milk")
  cart.updateProduct("Eggs")
  cart.deleteProduct("Eggs")
  cart.searchProduct("Milk")

}
