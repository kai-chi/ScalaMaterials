package intermediaterecipes.part2Testing.farm

case class Farm(name: String) {
  def tasksForTheDay(animals: Seq[Animal]): Seq[FarmTask] = {
    animals.flatMap {
      case animal @ Animal(_, _, Cow) =>
        Seq(FarmTask(animal, "milking"))
      case animal @ Animal(_, _, Chicken) =>
        Seq(FarmTask(animal, "checking for eggs"))
      case animal @ Animal (_, _, Horse) =>
        Seq(FarmTask(animal, "plowing"))

      case _ =>
        Seq()
    }
  }

}
