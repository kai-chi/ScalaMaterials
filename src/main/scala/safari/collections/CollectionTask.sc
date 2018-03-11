import java.time.LocalDateTime

import cashflow.patternsmatching.{Account, Address}
import traits.Person

val p = Person("Anne", LocalDateTime.now)

val a = Account(p, Address("NY", "USA"), 100.0, "USD")

//a.withdraw(1.0, "aaa")
//a.withdraw(111.0, "salary")
//a.deposit(100.0, "shopping")
//a.withdraw(45.0, "food")
//a.withdraw(10.0, "snacks")
//a.withdraw(88.0, "drinks")

//a.getTransactions().filter(t => t.amount > 0.0).foreach(println)

