/** ***************Pattern Matching ***********************/
val n = 5

n match {
  case 1 | 3 | 5 => println("It is odd")
  case 2 | 4 | 6 => println("It is even")
  case _ => println("Something else")
}

def doIt(x: Any) = x match {
  case _: Int => println("It's an Int")
  case _: String => println("It's a String")
  case _ => println("It's something else")
}

doIt(5)
doIt("abs")
doIt(1.0)


def doIt2(x: Any) = x match {
  case n: Int => println(s"It's an Int = $n")
  case s: String => println(s"It's a String = $s")
  case default => println(s"It's something else = $default")
}

doIt2(n)
doIt2("abc")
doIt2(33.0)

def doIt3(a: Int, b: Int) = (a, b) match {
  case (1, 1) => println("1,1")
  case (1, _) => println("1, _")
  case (_, 2) => println("_, 2")
  case (_, _) => println("default")
}


doIt3(1, 4)
doIt3(3, 2)

import java.time.LocalDateTime

case class Cashflow(amount: Double, currency: String, due: LocalDateTime)

val c1 = Cashflow(3000.0, "GBP", LocalDateTime.now)

c1 match {
  case Cashflow(v, "USD", _) => println("US cashflow")
  case Cashflow(v, "GBP", _) => println("UK cashflow")
}

case class Address(city: String, country: String)

case class Person(name: String, age: Int, address: Address)

val a1 = Address("London", "UK")
val a2 = Address("New York", "USA")

val p1 = Person("Fred", 41, a1)
val p2 = Person("Jane", 23, a2)

p1 match {
  case Person(n, _, Address("London", _)) => println(s"$n lives in London")
}

p2 match {
  case Person(n, a, _) if a > 30 => println(s"$n is older than 30")
  case Person(n, a, _) if a <= 30 => println(s"$n is a youngster")
}