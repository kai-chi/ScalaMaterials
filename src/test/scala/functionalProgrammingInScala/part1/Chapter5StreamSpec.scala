package functionalProgrammingInScala.part1

import functionalProgrammingInScala.part1.c5._
import org.specs2.mutable.Specification

class Chapter5StreamSpec extends Specification {
  "Stream" should {
    "create a fibonnaci sequence" in {
      val stream = Stream.fibs()
      stream.take(10).toList should_== List(0,1,1,2,3,5,8,13,21,34)
    }
  }
}
