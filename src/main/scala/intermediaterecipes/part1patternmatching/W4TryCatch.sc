def makeAnimalDance(animal: Animal): String = {
  if (animal.age > 18) {
    throw new AnimalTooOldException(animal.name, animal.age)
  } else {
    s"${animal.name} is dancing!"
  }
}

//throw new Exception("hello")

try {
  throw new Exception("hello")
} catch {
  case exception => println(exception)
}

def makeAnimalDance(animal: Animal): String = {
  if (animal.age > 18) {
    "We tried again! " + makeAnimalDance(animal)
  } else {
    s"${animal.name} is dancing!"
  }
}

//throw new MyException("boom")

try {
  throw new MyException("hello")
} catch {
  case exception => println(exception)
}

try {
  throw new Exception("hello")
} catch {
  case myException: MyException => println("this one was my fault")
  case exception: Exception => println("I wasn't expecting that")
}

def makeAnimalDance(animal: Animal): String = {
  if (animal.age > 18) {
    throw new AnimalTooOldException(animal.name, animal.age)
  } else {
    s"${animal.name} is dancing!"
  }
}

case class Animal(name: String, age: Int)

makeAnimalDance(Animal("Santiago", 12))
//makeAnimalDance(Animal("Santiago", 20))

try{
  makeAnimalDance(Animal("Santiago", 26))
} catch {
  case _: MyException => "This one was my fault"
  case AnimalTooOldException(name, age) if age < 25 => s"$name was too old at $age, but we let him dance anyway!"
}

class MyException(message: String) extends Exception(message)

makeAnimalDance(Animal("Santiago", 19))

try{
  makeAnimalDance(Animal("Santiago", 26))
} catch {
  case scala.util.control.NonFatal(_) => "This one was my fault"
}

case class AnimalTooOldException(name: String, age: Int) extends Exception(s"$name is older than 18; they are $age!")

try{
  makeAnimalDance(Animal("Santiago", 26))
} catch {
  case scala.util.control.NonFatal(_) => "This one was my fault"
}