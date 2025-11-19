package com.amandava.utils

object RangeDemo extends App {
  // simple range - last item is inclusive
  val numSeq = 1 to 4
  println(s"numseq: $numSeq")
  // last item is exclusive
  val numSeq2 = 1 until 4
  println(s"numseq2: $numSeq2")
  // default range increment is 1
  // to increase with a step of 2
  val numSeq3 = 1 until 10 by 2
  println("Iterating numSeq3 ...")
  for (item <- numSeq3) {
    println(s"item: $item")
  }
  // to convert from range to list type
  val numList = numSeq3.toList

}
