package com.amandava.functions

object ExampleFunction extends App {

  // applies 5% discount
//  def applyDiscount(cost: Double): Double = {
//    cost * (1 - 0.05)
//  }

  // single line function
  def applyDiscount(cost: Double) = cost * 0.95
  println(s"Price after discount: ${applyDiscount(100.00)}")

  // function that calls discount function
  def finalPrice(productPrice: Double,
                 quantity: Int,
                 discFunc: Double => Double): Double = {
    val totalPrice = productPrice * quantity
    discFunc(totalPrice)
  }
  println(s"Final price: ${finalPrice(100.01, 2, applyDiscount)}")
}
