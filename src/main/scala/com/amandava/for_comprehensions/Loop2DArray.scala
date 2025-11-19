package com.amandava.for_comprehensions

// this example loops through a 2 dimensional array
object Loop2DArray extends App {
  val foodCategories = Array.ofDim[String](3, 2)
  foodCategories(0)(0) = "Mango"
  foodCategories(0)(1) = "Kiwi"
  foodCategories(1)(0) = "Tomato"
  foodCategories(1)(1) = "Potato"
  foodCategories(2)(0) = "Milk"
  foodCategories(2)(1) = "Yogurt"

//  loop through the items
  for { i <- 0 until 3
        j <- 0 until 2
        } println(s"Item at index${(i, j)}: ${foodCategories(i)(j)}")
}
