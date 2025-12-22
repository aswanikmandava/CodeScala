package com.amandava.utils
import scala.util.Try

object TryFallback extends App {
  val input = "123a"
  // convert to int; fallback to 0 if it fails
  val result = Try(input.toInt).getOrElse(0)
  println(result)
  println(result.getClass)
}
