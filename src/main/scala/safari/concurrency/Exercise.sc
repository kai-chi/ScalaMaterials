import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Random, Success}

val r = new Random

val f1 = Future {
  Thread.sleep(r.nextInt(1000))
  val n = r.nextInt(100)
  println(s"f1: $n")
  n
}

val f2 = Future {
  Thread.sleep(r.nextDouble().toLong)
  val n = r.nextInt(101)
  println(s"f2: $n")
  n
}


val result = for {
  a <- f1
  b <- f2
} yield a > b

result.foreach(n => println(n))
result.failed.foreach(ex => println("failed"))