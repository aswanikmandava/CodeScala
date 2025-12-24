package com.amandava.functions

object CallbackFuncParam extends App {
  // define a function takes function as a parameter
  // call that function at a later time
  def printReport(sendEmail: () => Unit) = {
    println("start print report")
    // lookup data from the sources
    println("printing completed")
    sendEmail()     // run the callback function
  }

  // define a function with optional callback
  // default value is given for optional callback function parameter
  def printReport_v2(sendEmail: Option[() => Unit] = None): Unit = {
    println("start print report")
    // lookup data from the sources
    println("printing completed")
    sendEmail.foreach(f => f())
  }

  def notifyUser(): Unit = {
    println("sending email")
  }

  printReport(notifyUser)
  println("----------------")
  printReport_v2()  // no callback is passed
  println("----------------")
  printReport_v2(Some(notifyUser))
}
