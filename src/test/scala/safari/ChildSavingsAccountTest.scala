package safari

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import org.scalatest.{FlatSpec, Matchers}
import safari.cashflow.patternsmatching.Address
import safari.traits.{ChildSavingsAccount, Person}

class ChildSavingsAccountTest extends FlatSpec with Matchers {

  val dateAdult = "1990-01-01 11:11"
  val dateChild = "1999-01-01 11:11"
  val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
  val adult = Person("Maria", LocalDateTime.parse(dateAdult, formatter))
  val child = Person("Johny", LocalDateTime.parse(dateChild, formatter))
  val address = Address("Madrid","Spain")

  "A child account" should "not be created for adults" in {

  }

  it should "refuse to deposit from adults" in {
    val a =   new ChildSavingsAccount(adult, address, 100.0, "EUR")
    assert(!a.deposit(11.0))
    a.balance should be (100.0)
  }
}
