package hackerrank.datastructures

object LeftRotation {
  def main(args: Array[String]): Unit = {
    val scan = scala.io.StdIn
    val first = scan.readLine.trim.split(" ")
    val n = first(0).trim.toInt
    // eliminate looping
    val d = first(1).trim.toInt % n

    var nums : Array[Int] = scan.readLine.trim.split(" ").map(_.toInt)

    nums = nums.slice(d, n) ++ nums.slice(0, d)
    println(nums.mkString(" "))
  }
}
