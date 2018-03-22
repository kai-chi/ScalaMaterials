package hackerrank.datastructures

object Arrays2D {

  val coordinates: List[(Integer, Integer)] =
    List((0, 0), (0, 1), (0, 2),
                 (1, 1),
         (2, 0), (2, 1), (2, 2))

  def main(args: Array[String]): Unit = {
    val scan = scala.io.StdIn
    val arr = Array.ofDim[Int](6, 6)
    var max = Int.MinValue

    for (i <- 0 until 6) {
      val s = scan.readLine.trim.split(" ").map(_.toInt)
      for (j <- 0 until 6) {
        arr(i)(j) = s(j)
      }
    }

    for (i <- 0 until 4) {
      for (j <- 0 until 4) {
        val elements = coordinates.map((x) => (x._1+i,x._2+j))
        var sum = 0
        for(e <- elements) sum += arr(e._1)(e._2)
        if (sum > max) max = sum
      }
    }

    print(max)
  }
}
