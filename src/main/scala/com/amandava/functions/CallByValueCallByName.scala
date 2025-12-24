package com.amandava.functions

import scala.util.Random.nextInt

object CallByValueCallByName extends App {
  // x is evaluated first before entering the function
  def callByValue(x: Int): Unit = {
    println(s"x1: $x")
    println(s"x2: $x")
  }

  def callByName(x: => Int): Unit = {
    println(s"x1: $x")  // x is evaluated first time here
    println(s"x2: $x")  // x is re-evaluated again here
  }

  // random integer generator
  def randomInt(): Int = {
    val num = nextInt(50)
    println(s"Generating number: $num")
    num
  }

  println("Calling callByValue .....")
  callByValue(randomInt())
  println("Calling callByName .....")
  callByName(randomInt())
}
