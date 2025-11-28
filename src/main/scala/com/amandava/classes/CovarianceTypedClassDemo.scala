package com.amandava.classes

object CovarianceTypedClassDemo extends App {
  abstract class Product(name: String, price: Double) {
    def getInfo: Unit
  }

  case class Milk(name: String, price: Double, count: Int) extends Product(name, price) {
    override def getInfo: Unit = println(s"name: $name, price: $price")
  }

  case class EggBox(name: String, price: Double, count: Int) extends Product(name, price) {
    override def getInfo: Unit = println(s"Egg box")
  }

  // enabled covariance for class type using + prefix to type parameter
  class ShoppingCart[+T <: Product](items: Seq[T]) {
    def viewCart: Unit = items.foreach(_.getInfo)
  }
  val m1 = Milk("Maple Hill", 7.99, 1)
  val m2 = Milk("Organic Valley", 4.99, 1)
  val e1 = EggBox("Country Hill", 10.99, 1)
  val e2 = EggBox("Costco", 6.99, 1)
  val cart: ShoppingCart[Product] = new ShoppingCart[Milk](List(m1, m2))
  val cart2: ShoppingCart[Product] = new ShoppingCart[EggBox](List(e1, e2))
  cart.viewCart
  cart2.viewCart
}
