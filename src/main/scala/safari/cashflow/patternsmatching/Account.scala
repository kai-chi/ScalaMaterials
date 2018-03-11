package cashflow.patternsmatching

import java.time.LocalDateTime

import cashflow.Cashflow
import collections.Transaction
import traits.Person

import scala.collection.mutable.ListBuffer

case class Account(person: Person, address: Address, openingBalance: Double = 0.0, currency: String) {
  private var theBalance = openingBalance
  var transactions: ListBuffer[Transaction] = ListBuffer()

  transactions += Transaction(openingBalance, "Opening account", LocalDateTime.now)

//  def deposit(amount: Double, reason: String = "deposit") =
//    amount match {
//      case amt if amt > 0.0 => {
//        theBalance += amount
//        transactions += Transaction(amt, reason, LocalDateTime.now())
//        true
//      }
//      case _ => false
//
//    }

  def deposit(amount: Double, reason: String = "<Deposit>") =
    if (amount > 0.0) {
      transactions += Transaction(amount, reason, java.time.LocalDateTime.now())
      true
    }
    else
      false

  def withdraw(amount: Double, reason: String = "withdraw") =
    amount match {
      case amt if amt > 0.0 && theBalance - amt > 0.0 => {
        theBalance -= amount
        transactions += Transaction(amt, reason, LocalDateTime.now())
        true
      }
      case _ => false
    }


  def balance: Double = transactions.foldLeft(0.0)((x, y) => x + y.amount)


  def isOverdrawn() = {
    theBalance match {
      case b if b < 0.0 => println(s"account is overdrawn: $b")
      case b => println(s"account is not overdrawn: $b")
    }
  }

  def getTransactions() = transactions.toList
}

object Account {

}

case class Address(city: String, country: String)
