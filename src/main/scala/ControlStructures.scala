object ControlStructures {
  def main(args: Array[String]): Unit = {
    var counter: Int = 0
    while (counter < 5) {
//      println(s"Counter: $counter")
      println("Counter: " + counter)
      counter += 1
    }

    var i = 0
    do {
      // this block executes at least once
      println("i = " + i)
      i += 1
    } while (i < 3)

    // for loop syntax
    // for (var <- RANGE)
    // for (var <- start to end)
    for (j <- 1 to 3){
      println("j = " + j)
    }

    // nested for loop
    for (i <- 1 to 3; j <- 1 to 2) {
      println("i = " + i + "; j = " + j)
    }

    // loop through a list
    val fruits: List[String] = List("Mango", "Kiwi", "Grapes")
    for (item <- fruits) {
      println("Fruit: " + item)
    }

    // loop through a list conditionally
    for (item <- fruits; if item.length > 4) {
      println("Filtered Fruit: " + item)
    }

    // for loop as an expression
    val result = for {i <- 1 to 10; if i < 4} yield { i*i }
    println("result: " + result)
  }
}
