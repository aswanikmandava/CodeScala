package com.amandava.functions

import scala.util.Random

// this program will demonstrate the difference between call-by-name an call-by-value function
// parameters
object HigherOrderFunction_V3 extends App {
  // create a list of Tuple3 elements
  // each Tuple3 has productName, productCount, productPrice
  val listOrders = List(
    ("Eggs", 2, 10.99),
    ("Milk", 1, 6.99),
    ("Bread", 2, 5.99)
  )

  // define a function to loop through each Tuple3 element
  // calculate total cost
  def placeOrder(orders: List[(String, Int, Double)])(exchangeRate: Double): Double = {
    var totalCost = 0.0
    orders.foreach { prdOrder =>
      val productCost = prdOrder._2 * prdOrder._3 * exchangeRate
      println(s"Cost of ${prdOrder._2} ${prdOrder._1} with $exchangeRate exchange = $productCost")
      totalCost += productCost
    }
    totalCost
  }

  // call function with curried group parameters
  println("Total cost: " + placeOrder(listOrders)(1.5))

  // define a placeOrder function that takes exchange rate as call-by-name param
  def placeOrder_V2(orders: List[(String, Int, Double)])(exchangeRate: => Double): Double = {
    var totalCost = 0.0
    orders.foreach { prdOrder =>
      val productCost = prdOrder._2 * prdOrder._3 * exchangeRate
      println(s"Cost of ${prdOrder._2} ${prdOrder._1} = $productCost")
      totalCost += productCost
    }
    totalCost
  }

  val randomExgRate = new Random(10)

  def USDtoEuro(): Double = {
    val exchangeRate = randomExgRate.nextDouble()
    println(s"Generated the rate: $exchangeRate")
    exchangeRate
  }

  // call function using call by name parameter
  println("V2 - Total cost: " + placeOrder_V2(listOrders)(USDtoEuro()))

}
