package com.amandava.functions

object FunctionOption extends App {
  // function that returns a string optionally
  def getDiscountCode(p1: String): Option[String] = {
    if (p1.endsWith("_DSC")) {
      Some("CODE123")
    } else {
      None
    }
  }
  val todayCode: Option[String] = getDiscountCode("Umbrella")

  println(s"code: ${todayCode.getOrElse("NO DISCOUNT")}")

  // apply discount
  def applyDiscount(productNumber: String,
                    productCount: Int,
                    discountCode: Option[String]
                   ): Double = {
    discountCode match {
      case Some(value) =>
        val discount = 0.1
        val totalCost = 15 * productCount * (1 - discount)
        totalCost
      case None =>
        15 * productCount
    }
  }

  val getP1Cost: Double = applyDiscount("Product1", 2, None)
  println(s"p1 cost: $getP1Cost")

  val getP2Cost: Double = applyDiscount("Product2", 2, Some("CODE123"))
  println(s"p2 cost: $getP2Cost")
}
