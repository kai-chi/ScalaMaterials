import java.time.LocalDateTime

import scala.annotation.tailrec

3

val n = 3

"abc"

val s = "abc"

(n: Int) => n * n

val square = (n: Int) => n * n

square(4)

square.apply(4)

val sum = (a: Int, b: Int) => a + b

val cube = (n: Int) => n * n * n

def doIt(n: Int, f: Int => Int) = f(n)

doIt(3, cube)

def factorial(n: Int): Int = {
  @tailrec def fact(n: Int, acc: Int): Int = n match {
    case 0 => acc
    case m => fact(m - 1, m * acc)
  }

  fact(n, 1)
}

factorial(5)

object Test {
  def f(n: Int) = n + n
}

val f1 = (n: Int) => Test.f(n)

f1(2)

val f2 = Test.f _

f2(3)

case class Cashflow(amount: Double, currency: String, due: LocalDateTime)

val cf = Cashflow(1000.0, "USD", LocalDateTime.now)

def f(n: Int) = n match {
  case 1 => "one"
  case 2 => "two"
  case _ => "something else"
}

f(3)

val p: PartialFunction [Int, String] = {
  case 1 => "one"
  case 2 => "two"
}

p(3)

