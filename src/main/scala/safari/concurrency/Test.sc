import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._

val f1 = Future { Thread.sleep(1000); 50}

f1.foreach(n => println(n))

val f2= Future { Thread.sleep(1000); 3/0 }

f2.value

val ff = f2.failed
ff.foreach(n => println(n))

val f3 = f1.map(n => n * 2)

f3.value

val f4 = f1.filter(n => n > 20)

val p1 = Promise[Int]
val p2 = Promise[Int]

val pf1 = p1.future

val pf2 = p2.future

val result = for {
  a <- pf1
  b <- pf2
} yield a+b

result.value

p1.success(3)

result.value

p2.success(4)

result.value
