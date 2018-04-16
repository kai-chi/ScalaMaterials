package functionalProgrammingInScala.part1
import org.specs2.mutable.Specification


class Chapter3ListTest extends Specification {

  "List" should {
    val list = c3.List(1, 2, 3, 4, 5, 6)
    val l = c3.List(1, 6, 3, 88, 5)
    val ll = c3.List(c3.List(1, 6), c3.List(3, 88), c3.List(5))

    "concatenate list of lists into a list" in {
      val list = c3.List.concatenate(ll)
      list must_== l
    }

    "transform list by adding 1 to each element" in {
      val list = c3.List.transform(l)
      list must_== c3.List(2, 7, 4, 89, 6)
    }

    "turn a list of double to a list of string" in {
      val list: c3.List[Double] = c3.List(1.0, 6.0, 3.0, 88.0, 5.0)
      val listString = c3.List("1.0", "6.0", "3.0", "88.0", "5.0")
      c3.List.listToString(list) must_== listString
    }

    "map a list correctly" in {
      c3.List.map(l)(_ + 1) must_== c3.List(2, 7, 4, 89, 6)
      c3.List.map(c3.List("1.4", "2.22", "3"))(_.toDouble) must_== c3.List(1.4, 2.22, 3.0)
    }

    "filter a list" in {
      c3.List.filter(list)(_ > 3) must_== c3.List(4,5,6)
    }

    "flatMap a list" in {
      c3.List.flatMap(c3.List(1,2,3))(i => c3.List(i,i)) must_== c3.List(1,1,2,2,3,3)
    }

    "filter2 a list" in {
      c3.List.filter2(list)(_ > 3) must_== c3.List(4,5,6)
    }

    "combine two lists" in {
      c3.List.combine(c3.List(1,2,3),c3.List(4,5,6)) must_== c3.List(5,7,9)
    }
  }
}
