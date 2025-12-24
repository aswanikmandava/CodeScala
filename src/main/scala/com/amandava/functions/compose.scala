package com.amandava.functions

object compose extends App {
  val totalCost = 100.0

  // define a val function that applies discount
  val applyDiscount = (totalCost: Double) => {
    println(s"applying discount of 5% on $totalCost ...")
    val discount = totalCost * 0.05
    val finalPrice = totalCost - discount
    finalPrice
  }
  //  println(s"Cost after discount - ${applyDiscount(totalCost)}")

  // define a val function that applies tax
  val applyTax = (totalCost: Double) => {
    println(s"applying tax of 1% on $totalCost ...")
    val discount = totalCost * 0.01
    val finalPrice = totalCost - discount
    finalPrice
  }
  // The applyTax will be called first and then the applyDiscount was called
  // The output from applyTax will be passed through as an input parameter to the applyDiscount function
  val costAfterDiscTax = (applyDiscount compose applyTax)(totalCost)
  println(s"Cost after discount and tax: ${costAfterDiscTax}")

}
