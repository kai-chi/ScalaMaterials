package hackerrank.datastructures

object Arrays {

  def main(args: Array[String]): Unit = {
    val scan = scala.io.StdIn

    val n = scan.readLine.trim.toInt

    val numbers = scan.readLine.trim.split(" ")

    for(i <- 0 until n) {
      print(numbers(n-1-i) + " ")
    }
  }

}
