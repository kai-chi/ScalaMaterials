val ages: Map[String, Int] = Map ("Cleo" -> 10, "Santiago" -> 8, "Roger" -> 18)

ages.get("Cleo")
ages.get("Magical")

ages("Magical")
ages("Cleo")

//usually get an element from a map with .get
//it safer
ages.getOrElse("Cleo", -1)
ages.getOrElse("Magical", -1)

//adding element
ages + ("John" -> 58)

//removing element
res6 - "Cleo"

ages.map { (parameter) => println(parameter)}

ages.map {
  case (name, age) =>
    age
}

ages.map {
  case (name, age) =>
    name + " the funny" -> age
}

ages.map {
  case (name, age) =>
    name + " the funny" -> (age + 12)
}


ages.map {
  case (name, age) =>
    age -> name
}
//remember map will override duplicate keys

ages.mapValues { age => age + 12}

