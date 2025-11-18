package com.amandava.basics

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    val fname: String = "Aswani"
    val lname: String = "Mandava"
    val age: Int = 30
    // println(s"...") utilizes string interpolation, a powerful feature for
    // embedding variables and expressions directly within a string literal
    // variable substitution
    println(s"Name: $fname; Age: $age")
    // expression evaluation
    println(s"${fname + ' ' + lname}; Age: $age\nHave a nice day!!!")
  }
}