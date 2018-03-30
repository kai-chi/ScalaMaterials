val a = Animal("Santiago", 12, "Cat")

new Animal("Santiago", 12, "Cat")

val Animal(name, _, Classification(_, species)) = res6

val cat = Classification("felix", "felicis")


def describeAnimal(animal: Animal): String = {
  animal match {
    case Animal(name, age, species) =>
      s"$name is a $species, they are $age years old."
  }
}

def describeAnimal(animal: Animal): String = {
  animal match {
    case Animal(name, age, species) =>
      s"$name is a $species, they will be ${age + 1} years old next year."
  }
}

describeAnimal(a)

def describeAnimal(animal: Animal): String = {
  animal match {
    case Animal(name, age, "Cat") =>
      s"$name is a meowie friend who is $age years old."
    case Animal(name, age, species) =>
      s"$name is a $species, they will be ${age + 1} years old next year."
  }
}

describeAnimal(a)

def describeAnimal(animal: Animal): String = {
  animal match {
    case Animal(name, age, "Cat") if age > 10 =>
      s"$name is an old meowie friend who is $age years old."
    case Animal(name, age, "Cat") =>
      s"$name is a meowie friend who is $age years old."
    case Animal(name, age, species) =>
      s"$name is a $species, they will be ${age + 1} years old next year."
  }
}

describeAnimal(a)

def describeAnimal(animal: Animal): String = {
  animal match {
    case Animal(name, age, classification) =>
      s"$name is a $classification, they will be ${age + 1} years old next year."
  }
}

describeAnimal(a)
describeAnimal(a.copy(age = 8))

def describeAnimal(animal: Animal): String = {
  animal match {
    case Animal(name, age, classification @ Classification(genus, species)) =>
      println(classification)
      s"$name is a $genus $species, they will be ${age + 1} years old next year."
  }
}

class Animal(name: String, age: Int, species: String)

class Animal(val name: String, val age: Int, val species: String)

Animal("Santiago", 8, cat)

case class Animal(name: String, age: Int, species: String)

describeAnimal(res6)

describeAnimal(res6)

case class Animal(name: String, age: Int, classification: Classification)

case class Classification(genus: String, species: String)

name
species
