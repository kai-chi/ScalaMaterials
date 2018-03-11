import scala.util.{Failure, Success, Try}

val capitals = Map("UK" -> "London", "PL" -> "Warsaw", "DE" -> "Berlin")

capitals.get("UK")

val list = List("UK", "DE", "USA", "SWE")

list.map(s => capitals.get(s))
list.flatMap(s => capitals.get(s))

def strToInt(s: String) = Try { s.toInt }

strToInt("123") match {
  case Success(n) => println(n)
  case Failure(ex) => println(ex.getMessage)
}

strToInt("a123") match {
  case Success(n) => println(n)
  case Failure(ex) => println(ex.getMessage)
}

strToInt("123.111")


def sumStrings(s1: String, s2: String) =
for {
  x <- Try { s1.toInt }
  y <- Try { s2.toInt }
} yield x+y

sumStrings("123", "2")
sumStrings("123", "2x")
sumStrings("123*", "2")

val lst = List("1", "2", "as", "2g", "2.0", "44 + 33", "USA")
val lst1 = lst.map(s => strToInt(s))

lst1.collect { case Success(x) => x }