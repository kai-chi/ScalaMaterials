def describeWalking(animal: Animal): String = {
  "walk"
}

val santiago = Animal("Santiago", "Cat")
val cleo = Animal("Cleo", "Dog")

case class Animal(name: String, species: String)

describeWalking(santiago)
describeWalking(cleo)

val meow: PartialFunction[Animal, String] = {
  case Animal(_, "Cat") => "meow"
}

meow(santiago)
meow(cleo)

meow.isDefinedAt(santiago)
meow.isDefinedAt(cleo)

val meow2: PartialFunction[Animal, String] = {
  case Animal(_, "Cat") => "meow"
  case Animal(_, "Tiger") => "meow"
  case Animal(_, "Lion") => "roar"
}

meow2.isDefinedAt(santiago)
meow2.isDefinedAt(cleo)
meow2.isDefinedAt(Animal("A", "Tiger"))


val meow3: PartialFunction[Animal, String] = {
  case Animal(_, "Cat") => println("cat!"); "meow"
  case Animal(_, "Tiger") => println("tiger!"); "meow"
  case Animal(_, "Lion") => println("lion!"); "roar"
}

meow3.isDefinedAt(santiago)
meow3(santiago)

val meow4: PartialFunction[Animal, String] = {
  case Animal(_, "Cat") => "meow"
  case Animal(_, "Tiger") => "meow"
  case Animal(_, "Lion") => "roar"
}

val woof: PartialFunction[Animal, String] = {
  case Animal(_, "Dog") => "woof"
}

meow4(cleo)
woof(santiago)


val speak = meow4 orElse woof
val speakAlways = speak.applyOrElse(Animal("A", "Fish"), (animal: Animal) => "speak")



speak(santiago)
speak(cleo)
speak(Animal("A", "Lion"))
speak(Animal("A", "Fish"))
speakAlways


