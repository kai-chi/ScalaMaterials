import scala.annotation.tailrec

val lst = List(1, 2, 3)

val lst2 = 0 :: lst

class Holder[+T](val value: T) {
  def printIt = println(value)
}

val h1 = new Holder(3)
h1.printIt

class Person
class Employee extends Person

val h2 = new Holder(new Employee)

val h3: Holder[Person] = h2

val lst3 = 0 :: 1 :: 2 :: Nil

val empty = List()

val lst4 = lst :+ 4

val lst5 = List(5, 6, 7)

val lst6 = lst4 ::: lst5

val lst7 = List("ab", "cd")

val lst8 = lst4 ::: lst7

val lst9 = lst ::: lst

lst.head
lst.tail

def matchList[T](lst: List[T]): Unit = lst match {
  case List() => println("empty")
  case List(_) => println("single element")
  case List(1, _) => println("two elements, 1 is first")
  case List(_, _) => println("two elements")
}

val l = List(1, 2)
matchList(l)

@tailrec def printlist[T](lst: List[T]): Unit = lst match {
  case Nil => println("done")
  case h :: t =>
    println(s"$h")
    printlist(t)
}

printlist(lst5)