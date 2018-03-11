
import scala.util.{Failure, Success, Try}

val s = "123"

// classic try-catch
try {
  val n = s.toInt
}
catch {
  case ex: NumberFormatException => print(ex.getMessage)
}

// scala Try

val v1 = Try { s.toInt }

v1 match {
  case Success(n) => println(n)
  case Failure(ex) => println(ex.getMessage)
}

val s1 = "1m23"
val s2 = "456"

val result = for {
  n <- Try { s1.toInt }
  m <- Try { s2.toInt }
} yield n+m