val santiago = Animal("Santiago", "Cat")
val cleo = Animal("Cleo", "Dog")
val meow: PartialFunction[Animal, String] = {
  case Animal(_, "Cat") => "meow"
}
val meow2: PartialFunction[Animal, String] = {
  case Animal(_, "Cat") => "meow"
  case Animal(_, "Tiger") => "meow"
  case Animal(_, "Lion") => "roar"
}

describeWalking(santiago)
describeWalking(cleo)
val meow3: PartialFunction[Animal, String] = {
  case Animal(_, "Cat") => println("cat!"); "meow"
  case Animal(_, "Tiger") => println("tiger!"); "meow"
  case Animal(_, "Lion") => println("lion!"); "roar"
}

meow(santiago)
meow(cleo)

meow.isDefinedAt(santiago)
meow.isDefinedAt(cleo)
val meow4: PartialFunction[Animal, String] = {
  case Animal(_, "Cat") => "meow"
  case Animal(_, "Tiger") => "meow"
  case Animal(_, "Lion") => "roar"
}

meow2.isDefinedAt(santiago)
meow2.isDefinedAt(cleo)
meow2.isDefinedAt(Animal("A", "Tiger"))
val woof: PartialFunction[Animal, String] = {
  case Animal(_, "Dog") => "woof"
}

meow3.isDefinedAt(santiago)
meow3(santiago)
val speak = meow4 orElse woof
val speakAlways = speak.applyOrElse(Animal("A", "Fish"), (animal: Animal) => "speak")

meow4(cleo)
woof(santiago)

def describeWalking(animal: Animal): String = {
  "walk"
}

speak(santiago)
speak(cleo)
speak(Animal("A", "Lion"))
speak(Animal("A", "Fish"))

case class Animal(name: String, species: String)

