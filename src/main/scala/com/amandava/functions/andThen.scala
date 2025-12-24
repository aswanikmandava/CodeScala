package com.amandava.functions

// Calling andThen will take the result from the first function and
// pass it as input parameter to the second function.
object andThen extends App {

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
  // The applyDiscount will be called first andThen the applyTax was called
  // The output from applyDiscount will be passed through as an input parameter to the applyTax function
  val costAfterDiscTax = (applyDiscount andThen applyTax)(totalCost)
  println(s"Cost after discount and tax: ${costAfterDiscTax}")

}
