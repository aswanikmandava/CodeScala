object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    var fname: String = "Aswani";
    var lname: String = "Mandava"
    var age: Int = 30;
    // println(s"...") utilizes string interpolation, a powerful feature for
    // embedding variables and expressions directly within a string literal
    // variable substitution
    println(s"Name: $fname; Age: $age")
    // expression evaluation
    println(s"${fname + ' ' + lname}; Age: $age\nHave a nice day!!!")
  }
}

object IfElseIfExample {
  def main(args: Array[String]): Unit = {
    val playerName: String = "Sachin";
    if (playerName == "Sachin Tendulkar") {
      println("Indian")
    }
    else if (playerName == "Mark Waugh") {
      println("Australian")
    }
    else {
      println("Other")
    }
  }
}