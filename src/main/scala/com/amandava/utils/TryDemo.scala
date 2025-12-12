package com.amandava.utils

import scala.util.{Try, Success, Failure}

object TryDemo extends App {

  // define a method that converts an integer wrapped in quotes to integer
  def convertToInt(s: String): Try[Int] = Try(s.toInt)

  val metric = convertToInt("1000")
  val metric_2 = convertToInt("A1000")

  metric match {
    case Success(res) => println(s"Result: $res")
    case Failure(e) => println(s"FAIL: ${e.getMessage}")
  }

  metric_2 match {
    case Success(res) => println(s"Result: $res")
    case Failure(e) => println(s"FAIL: ${e.getMessage}")
  }

}
