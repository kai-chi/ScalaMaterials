import java.time.LocalDateTime

import cashflow.patternsmatching.{Account, Address}
import org.scalatest.{FlatSpec, Matchers}
import traits.Person

class AccountTest extends FlatSpec with Matchers {

  val ad = Address("Warsaw", "PL")
  val p = Person("Fred", LocalDateTime.now)
  val a1 = Account(p, ad, 100.0, "USD")
  val c = "USD"

  "An account" should "not be empty" in {
    a1.balance should be > 0.0
  }

  it should "have the correct balance after one deposit" in {
    val a = Account(p, ad, currency = c)
    a.deposit(100.0)
    a.balance should be (100.0)
  }

  it should "not accept negative deposits" in {
    a1.deposit(-1.0) should be (false)
  }

  it should "have the correct balance after one withdraw" in {
    val a = Account(p, ad, 100.0, c)
    a.withdraw(25.0)
    a.balance should be (75.0)
  }

  it should "not withdraw too much" in {
    val a = Account(p, ad, currency = c)
    a.deposit(50.0)
    assert(!a.withdraw(100.0))
    a.balance should be (50.0)
  }
  }

