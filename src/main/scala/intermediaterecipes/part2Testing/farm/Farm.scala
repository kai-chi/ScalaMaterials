package intermediaterecipes.part2Testing.farm

case class Farm(name: String) {
  def tasksForTheDay(animals: Seq[Animal]): Seq[FarmTask] = {
    animals.flatMap {
      case animal @ Animal(_, age, Cow) =>
        Seq(FarmTask(animal, "milking", age))
      case animal @ Animal(_, age, Chicken) =>
        Seq(FarmTask(animal, "checking for eggs", age))
      case animal @ Animal (_, age, Horse) =>
        Seq(FarmTask(animal, "plowing", age))
      case animal @ Animal (_, age, Wolf) =>
        throw new Exception("Wolfs are attacking the farm!")
      case _ =>
        Seq()
    }
  }

}
