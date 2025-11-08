object MatchExpressions {
  def main(args: Array[String]): Unit = {
    val fruit = "Kiwi"
    val result: Unit = fruit match {
      case "Kiwi" => println("Fruit of NZ")
      case "Dragan" => println("Fruit of China")
      case "Mango" => println("Fruit of India")
      case "Orange" => println("Fruit of US")
      case _ => println("Some default fruit")
    }
  }
}
