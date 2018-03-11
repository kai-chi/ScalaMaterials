package traits

import java.time.{LocalDateTime, ZoneId}
import java.util.concurrent.TimeUnit

import cashflow.patternsmatching.{Account, Address}

class ChildSavingsAccount(person: Person, address: Address, openingBalance: Double = 0.0, currency: String)
  extends Account(person, address, openingBalance, currency) with MaturingAmount {

  override def collect(): Double = {
    val balance = this.balance
    withdraw(balance)
    balance
  }

  override def deposit(amount: Double, reason: String = "pocket money"): Boolean = {
    val now = LocalDateTime.now.atZone(ZoneId.systemDefault).toInstant.toEpochMilli
    val millisOfBirth = person.dob.atZone(ZoneId.systemDefault).toInstant.toEpochMilli
    if (now - millisOfBirth > TimeUnit.DAYS.toMillis(365)) {
      false
    } else {
      super.deposit(amount)
    }
  }
}
