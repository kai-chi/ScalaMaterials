//4.
def namesOfFarmAnimals(myAnimals: Seq[Animal]): Seq[String] = {
  myAnimals.filter {
    case FarmAnimal(_) =>
      true
    case _ =>
      false
  }.map {
    case FarmAnimal(name) =>
      name
    case _ =>
      ""
  }
}

//1.
//def moveToAFarm(myAnimals: Seq[Animal]): Seq[Animal] = {
//  myAnimals.filter(isFarmAnimal)
//}

//2.
//def moveToAFarm(myAnimals: Seq[Animal]): Seq[Animal] = {
//  myAnimals.filter {
//    case FarmAnimal(_) =>
//      true
//    case _ =>
//      false
//  }
//}

//3.
//def moveToAFarm(myAnimals: Seq[Animal]): Seq[Animal] = {
//  myAnimals.filter {
//    case FarmAnimal(_) =>
//      true
//    case _ =>
//      false
//  }.map {
//    case FarmAnimal(name) =>
//      name
//    case _ =>
//      ""
//  }
//}

def namesOfFarmAnimals(myAnimals: Seq[Animal]): Seq[String] = {
  myAnimals.filter {
    case FarmAnimal(_, _) =>
      true
    case _ =>
      false
  }.map {
    case FarmAnimal(name, age) if age < 8 =>
      name
    case _ =>
      "too old"
  }
}

def namesOfFarmAnimals(myAnimals: Seq[Animal]): Seq[String] = {
  myAnimals.filter {
    case FarmAnimal(_) =>
      true
    case _ =>
      false
  }.map {
    case FarmAnimal(Animal(name, age, _)) if age < 8 =>
      name
    case _ =>
      "too old"
  }
}

namesOfFarmAnimals(Seq(Animal("Bessy", "Cow"), Animal("Santiago", "Cat"), Animal("Cleo", "Dog"), Animal("Betty", "Cow")))

def tasksForFarmAnimals(animals: Seq[Animal]): Seq[String] = {
  animals.filter {
    case FarmTask(_, _) =>
      true
    case _ =>
      false
  }.map {
    case FarmTask(Animal(name, _, _), task) =>
      s"$task: $name"
    case _ =>
      ""
  }
}

def tasksForFarmAnimals(animals: Seq[Animal]): Seq[String] = {
  animals.filter {
    case FarmTasks(_, _) =>
      true
    case _ =>
      false
  }.map {
    case FarmTasks(task1, task2) =>
      s"$task1, $task2"
    case _ =>
      ""
  }
}

def tasksForFarmAnimals(animals: Seq[Animal]): Seq[String] = {
  animals.filter {
    case FarmTasks(_, _, _) =>
      true
    case _ =>
      false
  }.map {
    case FarmTasks(task1, task2, task3) =>
      s"$task1, $task2, $task3"
    case _ =>
      ""
  }
}

namesOfFarmAnimals(Seq(Animal("Bessy", 3, "Cow"), Animal("Santiago", 1,  "Cat"), Animal("Cleo", 5, "Dog"), Animal("Betty", 9, "Cow")))

case class Animal(name: String, species: String)

case class Animal(name: String,age: Int, species: String)

namesOfFarmAnimals(Seq(Animal("Bessy", 3, "Cow"), Animal("Santiago", 1,  "Cat"), Animal("Cleo", 5, "Dog"), Animal("Betty", 9, "Cow")))

object FarmAnimal {
  def unapply(animal: Animal): Option[String] = {
    if (animal.species == "Cow") {
      Some(animal.name)
    } else {
      None
    }
  }
}

object FarmAnimal {
  def unapply(animal: Animal): Option[(String, Int)] = {
    if (animal.species == "Cow") {
      Some(animal.name, animal.age)
    } else {
      None
    }
  }
}

tasksForFarmAnimals(Seq(Animal("Bessy", 3, "Cow"), Animal("Santiago", 1,  "Cat"), Animal("Cleo", 5, "Dog"), Animal("Betty", 9, "Cow")))

object FarmAnimal {
  def unapply(animal: Animal): Option[Animal] = {
    if (animal.species == "Cow") {
      Some(animal)
    } else {
      None
    }
  }
}

object FarmTask {
  def unapply(animal: Animal): Option[(Animal, String)] = {
    if (animal.species == "Cow") {
      Some((animal, "milking"))
    } else {
      None
    }
  }
}

tasksForFarmAnimals(Seq(Animal("Bessy", 3, "Cow"), Animal("Santiago", 1,  "Cat"), Animal("Cleo", 5, "Dog"), Animal("Betty", 9, "Cow")))

object FarmTasks {
  def unapplySeq(animal: Animal): Option[Seq[String]] = {
    if (animal.species == "Cow") {
      Some(Seq("milking", "breeding", "fertilizing"))
    } else {
      None
    }
  }
}

tasksForFarmAnimals(Seq(Animal("Bessy", 3, "Cow"), Animal("Santiago", 1,  "Cat"), Animal("Cleo", 5, "Dog"), Animal("Betty", 9, "Cow")))
