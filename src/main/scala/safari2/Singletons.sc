val aPerson = new Person("Dave", 55)

class Person (val name: String, val age: Int)

People.allPeople

object People {
  var allPeople : Seq[Person] = Seq.empty
  def addPerson(person: Person) = {
    allPeople = allPeople.filter(_.name != person.name) :+ person
  }
}
People.addPerson(aPerson)

People.allPeople

object Person {
  def apply(name: String): Person =  {
    val person = new Person(name, 0)
    People.addPerson(person)
    person
  }
  def withAge(person: Person, newAge: Int): Person = {
    val updatedPerson = new Person(person.name, newAge)
    People.addPerson(updatedPerson)
    updatedPerson
  }
}

Person("Dave")

People.allPeople.map(_.name)
People.allPeople.map(_.age)

object Family extends App {
  println("This is my family!")
}