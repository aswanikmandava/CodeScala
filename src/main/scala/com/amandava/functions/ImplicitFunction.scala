package com.amandava.functions

import com.amandava.functions.ImplicitFunction.EggString
import ProductConversions._
// wildcard character _ will import values and implicit functions
// import will make them in scope

object ImplicitFunction extends App {
  class EggString(p: String) {
    val isCageFree: Boolean = p == "VitalFarms"
  }

  val royalEggs = "Royal Eggs"
  val vitalFarmEggs = "VitalFarms"

  println(s"Are Royal eggs cagefree ? ${royalEggs.isCageFree}")
  println(s"Are VitalFarm eggs cagefree ? ${vitalFarmEggs.isCageFree}")
}

object ProductConversions {
  implicit def productToString(p: String): EggString = new EggString(p)
}