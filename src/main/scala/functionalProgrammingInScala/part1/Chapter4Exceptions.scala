package functionalProgrammingInScala.part1

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

  def filter_1(f: A => Boolean): Option[A] = this match {
    case Some(a) if(f(a)) => this
    case _ => None
  }

  def variance(xs: Seq[Double]): Option[Double] =
    mean(xs) flatMap (m => mean(xs.map(x => math.pow(x - m, 2))))

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]

case class Employee(name: String, department: String)


object Chapter4Exceptions {


  val joeDepartment: Option[String] = lookupByNAme("Joe").map(_.department)

  def lookupByNAme(name: String): Option[Employee] = ???

}
