object DataTypesExamples {
  def main(args: Array[String]): Unit = {
    val myInt = 10
    // referring to primitive data types
    val myIntRef: AnyVal = myInt
    val myStr = "Data type"
    // referring to Object type
    val myStrRef: AnyRef = myStr
    // referring to any Object or primitive data type
    val myAnyRef: Any = myStr
    val myAnyRef2: Any = myInt

    // converts string to int
    val myStr2: Char = 'c'
    val myStrInt = myStr2.toInt
    val myStr3: String = "50"
    var myStrInt2 = myStr3.toInt
    println(s"myStrInt: $myStrInt, myStrInt2: $myStrInt2")

    val myFloat: Float = -3.14f
    val myFloatCastedInt: Int = myFloat.toInt
    println(s"Float is casted to Int: $myFloatCastedInt")

  }
}
