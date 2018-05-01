package functionalProgrammingInScala.part1

import functionalProgrammingInScala.part1.c5._
import org.specs2.mutable.Specification

class Chapter5StreamSpec extends Specification {
  "Stream" should {
    "create a fibonnaci sequence" in {
      val stream = Stream.fibs()
      stream.take(10).toList should_== List(0,1,1,2,3,5,8,13,21,34)
    }

    "start with a sequence" in {
      val s1 = Stream(1,2,3,4,5)
      val s2 = Stream(1,2,3)

      s1.startsWith(s2) should_== true
    }
  }
}
