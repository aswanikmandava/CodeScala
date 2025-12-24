package com.amandava.functions

object ValFunction extends App {
//  def applyDiscount(p: Double): Double = {
//    val discount = p * 0.05   // 5% discount
//    val finalPrice = p - discount
//    finalPrice
//  }

  // value function
  // anonymous function
  // Syntax-1
    // val applyDiscountValueFunction = (totalCost: Double) => { ... }
    // we did not specify the return type of the function and are making use of Scala Type Inference.

  // Syntax-2 - if you want to add the return type
  // val applyDiscountValueFunction: Double => Double = totalCost => { ... }
  val discFunc = (item: Double) => {
    val discount = item * 0.05 // 5% discount
    val finalPrice = item - discount
    finalPrice
  }

  // calling val function
  println("$100.0 after discount: " + discFunc(100.0))
}
