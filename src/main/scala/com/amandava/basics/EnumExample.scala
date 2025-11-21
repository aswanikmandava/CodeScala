package com.amandava.basics

object WeekDay extends Enumeration {
  type WeekDay = Value
//  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
  // to assign custom values
  val Mon = Value(100, "Mon")
  val Tue = Value(200, "Tue")
  val Wed = Value(300, "Wed")
  val Thu = Value(400, "Thu")
  val Fri = Value(500, "Fri")
  val Sat = Value(600, "Sat")
  val Sun = Value(700, "Sun")
}

object EnumExample extends App {
  val today = WeekDay.Fri
  println(s"Today: $today")

  // pattern match on enumeration
  val result = today match {
    case WeekDay.Fri => println(s"It's friday (value: ${WeekDay.Fri.id})")
    case _ => println("It's NOT a friday")
  }

  // Iterate over all values
  println("Going through all days ...")
  WeekDay.values.foreach(
    day => print(s"$day ")
  )



}