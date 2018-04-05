import intermediaterecipes.part2Testing.farm._

val animals = Seq(
  Animal("Babs", 12, Chicken),
  Animal("Lady", 4, Chicken),
  Animal("Babsie", 9, Cow),
  Animal("Bessy", 12, Cow),
  Animal("Lettie", 6, Cow),
  Animal("Douglas", 12, Horse),
  Animal("Cleo", 12, Dog),
  Animal("Bonnie", 9, Dog),
  Animal("Santiago", 12, Cat),
  Animal("Athena", 3, Cat)
)

//oldschool
animals.filter(_.age < 10).map(_.name)
//ugly & oldschool
animals.filter(_.age < 10).filter(_.species==Cow).map(_.name)

animals.collect {
  case Animal(name, age, _) if age < 10 =>
    name
}

animals.collect {
  case Animal(name, age, Cow) if age < 10 =>
    name
}

val animalsAndNumbers = 5 +: 3 +: animals

animalsAndNumbers.collect {
  case animal @ Animal(name, age, Cow) if age < 10 =>
    animal
}

//if we want to get only the first that fulfills the requirements
animals.collectFirst {
  case Animal(name, age, Cow) if age < 10 =>
    name
}

animals.collectFirst {
  case Animal(name, age, Horse) if age < 10 =>
    name
}

//we want a list of animals less than 10 and
//list that are older than 10
// can we do it in one operation?
animals.partition(_.age < 10)
val (youngerAnimals, olderAnimals) = animals.partition(_.age < 10)

//groups by species into a Map[Species, List[Animal]]
animals.groupBy(_.species)

//we can change it to Vectors!
animals.toVector.groupBy(_.species)
val (youngerAnimalsVector, olderAnimalsVector) = animals.toVector.partition(_.age < 10)

//how to get an element from a list/vector/map
animals(4)

//better
animals.lift(10)
animals(9)
