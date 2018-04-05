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

for (animal <- animals) print(animal.age + " ")

for {
  animal <- animals
  if animal.age >= 10

} println(animal)

for {
  animal <- animals
  if animal.age >= 10

} yield {
  animal.name
}


for {
  animal <- animals
  _ = println(animal + " iterating!")
  if animal.age >= 10
  number <- 1 to animal.age
} yield {
  animal.name + " number: " + number
}

for {
  animal <- animals
  _ = println(animal)
  if animal.age >= 10
  _ = println(animal)
  number <- 1 to animal.age
  _ = println(number)
} yield {
  animal.name + " number: " + number
}

//pattern matching
for {
  Animal(name, age, _) <- animals
  if age >= 10
  number <- 1 to age
} yield {
  name + " number: " + number
}

//filter for cows
for {
  Animal(name, age, Cow) <- animals
  if age >= 10
  number <- 1 to age
} yield {
  name + " number: " + number
}

