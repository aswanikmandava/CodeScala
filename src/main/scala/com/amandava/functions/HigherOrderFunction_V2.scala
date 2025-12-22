package com.amandava.functions

object HigherOrderFunction_V2 extends App {
  // single line function
  def applyDiscount(cost: Double): Double = cost * 0.95
  println(s"Price after discount: ${applyDiscount(100.00)}")

  // curried function
  // function with curried parameter groups
  def finalPrice(productPrice: Double)(quantity: Int)(f: Double => Double): Double = {
    val totalPrice = productPrice * quantity
    // apply discount
    f(totalPrice)
  }

  // multiple ways to call this function
  // method-1
  val result = finalPrice(5.99)(2){
    cost =>
      val discount = 0.05   // 5%
      val discountPrice = cost * discount
      cost - discountPrice
  }
  println(s"result=$result")

  val result2 = finalPrice(5.99)(2)(applyDiscount)
  // this is evaluated as
  // applyDiscount(5.99 * 2)
  println(s"result2=$result2")
}
