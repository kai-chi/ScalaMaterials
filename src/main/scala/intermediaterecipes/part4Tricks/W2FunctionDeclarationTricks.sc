def makeAnimal(name: String, age: Int): String = {
  s"Animal $name is $age yours old."
}

makeAnimal("Cleo", 10)

// default parameters
def makeAnimal(name: String, age: Int = 0): String = {
  s"Animal $name is $age yours old."
}

makeAnimal("Cleo")

def makeAnimal(name: String, age: Int = 0, species: Option[String] = None): String = {
  s"Animal $name is $age yours old${species.map { s => " and they are a " + s} getOrElse ""}."
}

makeAnimal("Cleo")
makeAnimal("Cleo", species = Some("Dog"))
makeAnimal("Cleo", age = 9)


makeAnimal("Cleo", age = 9, species = Some("Dog"))


//call by name parameters
def youngOrOldAnimal(age: Int, youngName: String, oldName: String) = {
  if (age < 10) {
    youngName
  } else {
    oldName
  }
}

def youngName(name: String) = {
  println("creating young name!")
  "young " + name
}

def oldName(name: String) = {
  println("creating old name!")
  "old " + name
}

//let's check when the functions are invoked
youngOrOldAnimal(12, youngName("Cleo"), oldName("Cleo"))
youngOrOldAnimal(9, youngName("Cleo"), oldName("Cleo"))
// it invoked both! - normal
// let's make it lazy, bc maybe invoking is expensive (db or something)

def youngOrOldAnimal(age: Int, youngName: =>String, oldName: =>String): String = {
  if (age < 10) {
    youngName
  } else {
    oldName
  }
}

youngOrOldAnimal(12, youngName("Cleo"), oldName("Cleo"))
youngOrOldAnimal(9, youngName("Cleo"), oldName("Cleo"))

def printingArithmeticErrors[T](fn: =>T): Option[T] = {
  try {
    Some(fn)
  } catch {
    case e: ArithmeticException =>
      println(e)
      None
  }
}

printingArithmeticErrors(5/0)

printingArithmeticErrors {
  (0 to 5).map(5 / _)
}
