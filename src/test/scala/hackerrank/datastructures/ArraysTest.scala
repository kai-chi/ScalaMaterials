package hackerrank.datastructures

import java.io.ByteArrayInputStream

import org.scalatest.{FlatSpec, Matchers}

import scala.io.StdIn

class ArraysTest extends FlatSpec with Matchers {

  "Read line" should "work" in {
    val in = new ByteArrayInputStream("abc".getBytes())

    Console.withIn(in) {
      assert(StdIn.readLine() === "abc")
    }
  }

  "Array" should "be printed backwards" in {
    val n = new ByteArrayInputStream("4".getBytes())
    val num = new ByteArrayInputStream("1 2 3 4".getBytes())
    //TODO: finish the test
  }

}
