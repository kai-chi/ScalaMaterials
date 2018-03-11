package cashflow

import java.time.LocalDateTime


case class Cashflow(amount: Double, currency: String, due: LocalDateTime) {
  def this(amount: Double, due: LocalDateTime) = this(amount, "USD", due)

  def this(amount: Double) = this(amount, "GBP", LocalDateTime.now())

  val settle = due.toLocalDate.plusDays(2)
  private lazy val processedAt = LocalDateTime.now

  def rollForward() = {
    val retval = new Cashflow(amount, currency, due.plusDays(1))
    retval.processedAt
    retval
  }
}

object Cashflow {
  def main(args: Array[String]) = {
    val c1 = new Cashflow(100.0)
    println(c1.settle)

    val c2 = c1.rollForward()
    Thread.sleep(1000)
    println(c2.settle)
    println("c1 " + c1.processedAt)
    println("c2 " + c2.processedAt)
  }
}