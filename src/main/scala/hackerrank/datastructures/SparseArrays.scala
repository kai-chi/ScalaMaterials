package hackerrank.datastructures

object SparseArrays {
  def main(args: Array[String]): Unit = {
    val scan = scala.io.StdIn
    val N = scan.readInt
    val lines = Array.ofDim[String](N)

    for (i <- 0.until(N)) {
      lines(i) = scan.readLine
    }

    val Q = scan.readInt

//    val queries = Array.ofDim[String](N)
    val res = Array.ofDim[Int](Q)
    for (i <-0.until(Q)) {
      val query = scan.readLine
      var temp = 0
      for (j <-0.until(N)) {
        if (lines(j).equals(query)) {
          temp = temp + 1
        }
      }
      println(temp)
    }

  }
}
