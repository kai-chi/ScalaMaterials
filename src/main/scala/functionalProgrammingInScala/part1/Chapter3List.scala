package functionalProgrammingInScala.part1

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](l: List[A]): List[A] = l match {
    case Nil => sys.error("tail of empty list")
    case Cons(_, t) => t
  }

  def setHead[A](l: List[A], h: A): List[A] = l match {
    case Nil => sys.error("setHead on empty list")
    case Cons(_, t) => Cons(h, t)
  }

  @tailrec def drop[A](l: List[A], n: Int): List[A] =
    if (n <= 0) l
    else l match {
      case Nil => Nil
      case Cons(_, t) => drop(t, n - 1)
    }

  @tailrec def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h, t) if f(h) => dropWhile(t, f)
    case _ => l
  }

  def init[A](l: List[A]): List[A] = l match {
    case Nil => sys.error("init of an empty list")
    case Cons(_, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))
  }

  def init2[A](l: List[A]): List[A] = {
    val buf = new ListBuffer[A]

    @tailrec def go(cur: List[A]): List[A] = cur match {
      case Nil => sys.error("init of empty list")
      case Cons(_, Nil) => List(buf.toList: _*)
      case Cons(h, t) => buf += h; go(t)
    }

    go(l)
  }

  //calling dropWhile would require specifying argument of f like this:
  // dropWhile(xs, (x: Int) => x < 4)
  // we don't like it so we refactore dropWhile

  @tailrec def dropWhile2[A](as: List[A])(f: A => Boolean): List[A] =
    as match {
      case Cons(h, t) if f(h) => dropWhile2(t)(f)
      case _ => as
    }

  //now we can use dropWhile2 without annotations, like this:
  // dropWhile2(xs)(x => x < 4)

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def sum2(ns: List[Int]) =
    foldRight(ns, 0)(_ + _)

  def product2(ns: List[Double]) =
    foldRight(ns, 1.0)(_ * _)

  def length[A](as: List[A]): Int =
    foldRight(as, 0)((_, acc) => acc + 1)

  @tailrec def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  }

  def sum3(ns: List[Int]) =
    foldLeft(ns, 0)(_ + _)

  def product3(ns: List[Double]) =
    foldLeft(ns, 1.0)(_ * _)

  def length3[A](as: List[A]): Int =
    foldLeft(as, 0)((acc, _) => acc + 1)

  def reverse[A](l: List[A]): List[A] =
    foldLeft(l, Nil: List[A])((acc, h) => Cons(h, acc))

  //Exercise 3.13
  def foldRightViaFoldLeft[A,B](l: List[A], z: B)(f: (A,B) => B): B =
    foldLeft(reverse(l), z)((b,a) => f(a,b))

  def foldRightViaFoldLeft_1[A,B](l: List[A], z: B)(f: (A,B) => B): B =
    foldLeft(l, (b:B) => b)((g,a) => b => g(f(a,b)))(z)

  def foldLeftViaFoldRight[A,B](l: List[A], z: B)(f: (B,A) => B): B =
    foldRight(l, (b:B) => b)((a,g) => b => g(f(b,a)))(z)

  //Exercise 3.14
  def append[A](l: List[A], r: List[A]): List[A] =
    foldRight(l, r)(Cons(_, _))

  //Exercise 3.15
  def concatenate[A](l: List[List[A]]): List[A] =
    foldRight(l, Nil: List[A])(append)

  //Exercise 3.16
  def transform(l: List[Int]): List[Int] =
    foldRight(l, Nil: List[Int])((h, t) => Cons(h + 1, t))

  //Exercise 3.17
  def listToString(l: List[Double]): List[String] =
    foldRight(l, Nil: List[String])((h, t) => Cons(h.toString, t))

  //Exercise 3.18
  def map[A, B](as: List[A])(f: A => B): List[B] =
    foldRight(as, Nil: List[B])((h, t) => Cons(f(h), t))

  //Exercise 3.19
  def filter[A](as: List[A])(f: A => Boolean): List[A] =
    foldRight(as, Nil: List[A])((h, t) => if (f(h)) Cons(h, t) else t)

  //Exercise 3.20
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
  //    foldRight(as, Nil: List[B])((h,t) => append(f(h), t))
    concatenate(map(as)(f))

  //Exercise 3.21
  def filter2[A](as: List[A])(f: A => Boolean): List[A] =
    flatMap(as)((h) => if (f(h)) List(h) else Nil)

  //Exercise 3.22
  def combine(l1: List[Int], l2: List[Int]): List[Int] = (l1, l2) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(h1 + h2, combine(t1, t2))
  }

  //Exercise 3.23
  def zipWith[A, B, C](l1: List[A], l2: List[B])(f: (A, B) => C): List[C] = (l1, l2) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(f(h1, h2), zipWith(t1, t2)(f))
  }

  //Exercise 3.24 TODO
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = ???

}

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {
  //Exercise 3.25
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + size(l) + size(r)

  }

  //Exercise 3.26
  def maximum(t: Tree[Int]): Int = t match {
    case Leaf(l) => l
    case Branch(l, r) => maximum(l) max maximum(r)
  }

  //Exercise 3.27
  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }

  //Exercise 3.28
  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = t match {
    case Leaf(l) => Leaf(f(l))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }

  //Exercise 3.29
  def fold[A, B](t: Tree[A])(f: A => B)(g: (B, B) => B): B = t match {
    case Leaf(a) => f(a)
    case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
  }

  def sizeViaFold[A](t: Tree[A]): Int =
    fold(t)(_ => 1)(1 + _ + _)

  def maximumViaFold(t: Tree[Int]): Int =
    fold(t)(a => a)(_ max _)

  def depthViaFold[A](t: Tree[A]): Int =
    fold(t)(a => 1)((d1, d2) => 1 + (d1 max d2))

  def mapViaFold[A, B](t: Tree[A])(f: A => B): Tree[B] =
    fold(t)(a => Leaf(f(a)): Tree[B])(Branch(_,_))
}
