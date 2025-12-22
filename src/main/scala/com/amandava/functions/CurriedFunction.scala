package com.amandava.functions

//  Scala allows you to create functions where each parameter is enclosed within its own group
object CurriedFunction extends App {

  // function with curried parameter groups
  def completeOrder(prodName: String)(prodCount: Int)(prodCost: Double): Double = {
    println(s"Completing order for $prodName")
    // get discount by product
    val discount = prodName match {
      case "Milk" => 2
      case "Eggs" => 1
      case _ => 1
    }
    prodCount * (prodCost - discount)
  }
  // call function with curried parameter groups
  val totalPrice = completeOrder("Milk")(2)(2.99)
  println(s"total=$totalPrice")

  // create partially applied function
  val totalEggPrice = completeOrder("Eggs") _

  println(totalEggPrice(3)(3.99))

}
