package functionalProgrammingInScala.part1

import scala.{Either => _, Option => _, Some => _} // hide std library `Option`, `Some` and `Either`, since we are writing our own in this chapter

sealed trait Option[+A] {
  def flatMap_1[B](f: A => Option[B]): Option[B] = this match {
    case None => None
    case Some(a) => f(a)
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] =
    this map (Some(_)) getOrElse ob

  def orElse_1[B >: A](ob: => Option[B]): Option[B] = this match {
    case None => ob
    case _ => this
  }

  def filter(f: A => Boolean): Option[A] =
    flatMap(a => if (f(a)) Some(a) else None)

  def flatMap[B](f: A => Option[B]): Option[B] =
    map(f) getOrElse None

  def map[B](f: A => B): Option[B] = this match {
    case Some(a) => Some(f(a))
    case None => None
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case None => default
    case Some(a) => a
  }

  val absO: Option[Double] => Option[Double] = lift(math.abs)

  def filter_1(f: A => Boolean): Option[A] = this match {
    case Some(a) if (f(a)) => this
    case _ => None
  }

  // Exercise 4.2
  def variance(xs: Seq[Double]): Option[Double] =
    mean(xs) flatMap (m => mean(xs.map(x => math.pow(x - m, 2))))

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)

  def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f

}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]

object Option {

  //using for-comprehension
  def map2_1[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C):
  Option[C] =
    for {
      aa <- a
      bb <- b
    } yield f(aa, bb)


  def parseInsuranceRateQuote(age: String, numberOfSpeedingTickets: String): Option[Double] = {
    val optAge: Option[Int] = Try(age.toInt)
    val optTickets: Option[Int] = Try(numberOfSpeedingTickets.toInt)
    map2(optAge, optTickets)(insuranceRateQuote)
  }

  def insuranceRateQuote(age: Int, numberOfSpeedingTickets: Int): Double = ???

  def Try[A](a: => A): Option[A] =
    try Some(a)
    catch {
      case e: Exception => None
    }

  // Exercise 4.3
  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    a flatMap (aa => b map (bb => f(aa, bb)))

//  def sequence_1[A](a: scala.List[Option[A]]): Option[scala.List[A]] =
//    a.foldRight[Option[List[A]]](Some(Nil))((x, y) => map2(x, y)(_ :: _))

  // Exercise 4.4
  def sequence[A](a: scala.List[Option[A]]): Option[scala.List[A]] = a match {
    case scala.Nil => Some(scala.Nil)
    case h :: t => h flatMap (hh => sequence(t) map (hh :: _))
  }

//  def traverse_1[A, B](a: scala.List[A])(f: A => Option[B]): Option[scala.List[B]] =
//    a.foldRight[Option[List[B]]](Some(Nil))((h, t) => map2(f(h), t)(_ :: _))

  // Exercise 4.5
  def traverse[A, B](a: scala.List[A])(f: A => Option[B]): Option[scala.List[B]] = a match {
    case scala.Nil => Some(scala.Nil)
    case h :: t => map2(f(h), traverse(t)(f))(_ :: _)
  }

  def sequenceViaTraverse[A](a: scala.List[Option[A]]): Option[scala.List[A]] =
    traverse(a)(x => x)

}
