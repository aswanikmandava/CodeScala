object IfElseIfExamples {
  def main(args: Array[String]): Unit = {
    val playerName: String = "Sachin"
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