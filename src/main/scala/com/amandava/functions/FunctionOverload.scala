package com.amandava.functions

object FunctionOverload extends App {
  // function that takes string input
  def getDiscount(productName: String) = {
    println(s"discount applied for product: $productName")
  }
  // function that takes Double input
  def getDiscount(productCost: Double) = {
    println(s"discount applied for cost: $productCost")
  }

  getDiscount("Umbrella")
  getDiscount(125.10)

}
