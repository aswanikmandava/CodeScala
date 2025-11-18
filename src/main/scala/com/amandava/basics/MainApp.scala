package com.amandava.basics

object MainApp extends App {
  println("Basic scala app with out writing main method")
  println("Commandline args are: ")
  println(args.mkString(", "))
  val appDbUrl = sys.env("DB_URL")
  val appEnv = sys.env("APP_ENV")
  println(s"URL: $appDbUrl, ENV: $appEnv")
}
