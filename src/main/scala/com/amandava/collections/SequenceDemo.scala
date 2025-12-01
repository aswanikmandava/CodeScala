package com.amandava.collections

object SequenceDemo extends App {
  // Sequence is a trait
  // By default, Seq.apply returns an immutable List implementation
  val mySeq: Seq[String] = Seq("One", "Two", "Three")
  println(mySeq)
}
