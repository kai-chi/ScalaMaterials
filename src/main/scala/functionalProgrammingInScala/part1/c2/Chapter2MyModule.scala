package functionalProgrammingInScala.part1.c2

import scala.annotation.tailrec

object Chapter2MyModule {

  //Exercise 2.1
  def fib(n: Int): Int = {
    @tailrec def go(n: Int, current: Int, previous: Int): Int =
      if (n == 0) previous
      else go(n - 1, current + previous, current)

    go(n, 1, 0)
  }

  //monomorphic function to find a String in an array
  def findFirstMonomorphic(ss: Array[String], key: String): Int = {
    @tailrec def loop(n: Int): Int =
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)

    loop(0)
  }

  //polymorphic version
  def findFirstPolymorphic[A](as: Array[A], p: A => Boolean): Int = {
    @tailrec def loop(n: Int): Int =
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)

    loop(0)
  }

  //Exercise 2.2
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec def loop(n: Int): Boolean =
      if (n >= as.length - 1) true
      else if (ordered(as(n - 1), as(n))) loop(n + 1)
      else false

    loop(1)
  }

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C =
  //    (b: B) => f(a, b)
  //  type can be omitted...
    b => f(a, b)

  //Exercise 2.3
  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)

  //Exercise 2.4
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)

  //Exercise 2.5
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    a => f(g(a))

  def main(args: Array[String]): Unit = {
    println(formatResult("absolute", -42, abs))
    println(formatResult("factorial", 7, factorial))
  }

  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  def factorial(n: Int): Int = {
    @tailrec def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n - 1, acc * n)

    go(n, 1)
  }

  private def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }
}
