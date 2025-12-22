package com.amandava.classes

// this program to demo how a regular class can behave like a case class
// scala behind the scenes do all this via case class
object RegularClassMimicCaseClass extends App {
  class Person(val name: String, val age: Int) {
    // this is used to check if first object is equal to the second object
    override def equals(obj: Any): Boolean = obj match {
      case other: Person =>
        // Person class constructor parameters are turned into fields by adding val
        // other.name and other.age will be accessible to companion object unapply method
        // this is automatically done for case class
        this.name == other.name && this.age == other.age
      case _ => false
    }
    // this should be consistent with equals
    override def hashCode(): Int = {
      31 * name.hashCode + age
    }
    def copy(name: String = this.name, age: Int = this.age): Person = new Person(name, age)

    // String representation of Person object
    override def toString: String = s"Person(name=$name, age=$age)"
  }
  // companion object
  object Person {
    // constructor with out 'new'
    def apply(name: String, age: Int): Person = {
      new Person(name, age)
    }

    // unapply method - extractor
    // used during pattern matching
    def unapply(p: Person): Option[(String, Int)] = {
      Some((p.name, p.age))
    }
  }
  // create an instance(object) to Person
  val p1 = Person("Aswani", 42)
  val p2 = Person("Anil", 41)
  val p3 = p1.copy()
  println(p1)
  println(p1.equals(p2))
  println(p1.hashCode())
  println(p2.hashCode())
  println(s"p3=${p3}")
  println(p1 == p3)
  println(p1.hashCode())
  println(p3.hashCode())
  p1 match {
    case Person(n, a) => println(s"Name: $n, Age: $a")
  }
}


