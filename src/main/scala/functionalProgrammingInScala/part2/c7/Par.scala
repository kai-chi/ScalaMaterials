package functionalProgrammingInScala.part2.c7

import java.util.concurrent.{ExecutorService, Future, TimeUnit}

object Par {

  type Par[A] = ExecutorService => Future[A]

  def unit[A](a: A): Par[A] = (es: ExecutorService) => UnitFuture(a)

  def lazyUnit[A](a: => A): Par[A] = fork(unit(a))

  def run[A](s: ExecutorService)(a: Par[A]): A = a(s)

  def fork[A](a: => Par[A]): Par[A] =
    es => es.submit(() => a(es).get)

  def map2[A, B, C](a: Par[A], b: Par[B])(f: (A, B) => C): Par[C] =
    (es: ExecutorService) => {
      val af = a(es)
      val bf = b(es)
      //      UnitFuture(f(af.get, bf.get))
      //Exercise 7.3
      Map2Future(af, bf, f)
    }

  def sum(ints: IndexedSeq[Int]): Par[Int] = {
    if (ints.size <= 1) {
      Par.unit(ints.headOption getOrElse 0)
    }
    else {
      val (l, r) = ints.splitAt(ints.length / 2)
      Par.map2(Par.fork(sum(l)), Par.fork(sum(r)))(_ + _)
    }
  }

  //Exercise 7.4
  def asyncF[A, B](f: A => B): A => Par[B] =
    a => lazyUnit(f(a))

  def sortPar(parList: Par[List[Int]]): Par[List[Int]] =
    map2(parList, unit(()))((a, _) => a.sorted)

  def map[A, B](pa: Par[A])(f: A => B): Par[B] =
    map2(pa, unit(()))((a, _) => f(a))

  def sortParViaMap(parList: Par[List[Int]]) = map(parList)(_.sorted)

  def sequence[A](fbs: List[Par[A]]): Par[List[A]] =
    fbs.foldRight[Par[List[A]]](unit(List()))((h,t) => map2(h,t)(_ :: _))

  def parFilter[A](as: List[A])(f: A => Boolean): Par[List[A]] = {
    val pars: List[Par[List[A]]] =
      as map asyncF((a: A) => if (f(a)) List(a) else List())
    map(sequence(pars))(_.flatten)

  }

  def parMap[A, B](ps: List[A])(f: A => B): Par[List[B]] = {
    val fbs: List[Par[B]] = ps.map(asyncF(f))
    sequence(fbs)
  }


  private case class UnitFuture[A](a: A) extends Future[A] {
    override def cancel(b: Boolean): Boolean = false

    override def isCancelled: Boolean = false

    override def isDone: Boolean = true

    override def get(): A = get

    override def get(l: Long, timeUnit: TimeUnit): A = ???
  }

  private case class Map2Future[A, B, C](af: Future[A], bf: Future[B], f: (A, B) => C) extends Future[C] {

    @volatile var cache: Option[C] = None

    override def cancel(b: Boolean): Boolean = af.cancel(b) || bf.cancel(b)

    override def isCancelled: Boolean = af.isCancelled || bf.isCancelled

    override def isDone: Boolean = cache.isDefined

    override def get(): C = compute(Long.MaxValue)

    override def get(l: Long, timeUnit: TimeUnit): C =
      compute(TimeUnit.NANOSECONDS.convert(l, timeUnit))

    private def compute(timeoutInNanos: Long): C = cache match {
      case Some(c) => c
      case None =>
        val start = System.nanoTime
        val ar = af.get(timeoutInNanos, TimeUnit.NANOSECONDS)
        val stop = System.nanoTime
        val aTime = stop - start
        val br = bf.get(timeoutInNanos - aTime, TimeUnit.NANOSECONDS)
        val ret = f(ar, br)
        cache = Some(ret)
        ret
    }
  }

}