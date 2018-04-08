package functionalProgrammingInScala.part1
import org.specs2.mutable.Specification


class Chapter3ListTest extends Specification {

  "List" should {
    val list = List(1, 2, 3, 4, 5, 6)
    val l = List(1, 6, 3, 88, 5)
    val ll = List(List(1, 6), List(3, 88), List(5))

    "concatenate list of lists into a list" in {
      val list = List.concatenate(ll)
      list must_== l
    }

    "transform list by adding 1 to each element" in {
      val list = List.transform(l)
      list must_== List(2, 7, 4, 89, 6)
    }

    "turn a list of double to a list of string" in {
      val list: List[Double] = List(1.0, 6.0, 3.0, 88.0, 5.0)
      val listString = List("1.0", "6.0", "3.0", "88.0", "5.0")
      List.listToString(list) must_== listString
    }

    "map a list correctly" in {
      List.map(l)(_ + 1) must_== List(2, 7, 4, 89, 6)
      List.map(List("1.4", "2.22", "3"))(_.toDouble) must_== List(1.4, 2.22, 3.0)
    }

    "filter a list" in {
      List.filter(list)(_ > 3) must_== List(4,5,6)
    }

    "flatMap a list" in {
      List.flatMap(List(1,2,3))(i => List(i,i)) must_== List(1,1,2,2,3,3)
    }

    "filter2 a list" in {
      List.filter2(list)(_ > 3) must_== List(4,5,6)
    }

    "combine two lists" in {
      List.combine(List(1,2,3),List(4,5,6)) must_== List(5,7,9)
    }
  }
}
