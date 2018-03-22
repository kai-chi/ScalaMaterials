package hackerrank.datastructures

import scala.collection.mutable.ArrayBuffer

object DynamicArray {

  def main(args: Array[String]): Unit = {
    val scan = scala.io.StdIn
    val first = scan.readLine.trim.split(" ").map(_.toInt)

    val N = first(0)
    val Q = first(1)
    var lastAnswer = 0

    val seqList = Array.ofDim[ArrayBuffer[Int]](N)

    for (i <- 0.until(N))
      seqList(i) = new ArrayBuffer[Int]

    for (i <- 0.until(Q)) {
      val query = scan.readLine.trim.split(" ").map(_.toInt)
      val index = (query(1) ^ lastAnswer) % N
      var seq = seqList(index)
      if (query(0) == 1) {
        seq += query(2)
      }
      else {
        lastAnswer = seq(query(2) % seq.size)
        println(lastAnswer)
      }
    }
  }
}
