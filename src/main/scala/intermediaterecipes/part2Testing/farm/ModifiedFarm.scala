package intermediaterecipes.part2Testing.farm

class ModifiedFarm(name: String, tasker: ModifiedFarmTasker) {
  def runForDays(maxAge: Int, days: Int): Seq[FarmTask] = {
    for {
      day <- 1 to days
      task <- tasker.tasksForTheDay(maxAge)
    } yield {
      task
    }
  }
}

class ModifiedFarmTasker(animals: Seq[Animal]) {
  def tasksForTheDay(maxAge: Int): Seq[FarmTask] = {
    animals.flatMap {
      case animal @ Animal(_, age, Cow) if age < maxAge =>
        Seq(FarmTask(animal, "milking", age))

      case animal @ Animal(_, age, Chicken) if age < maxAge =>
        Seq(FarmTask(animal, "checking for eggs", age))

      case animal @ Animal (_, age, Horse) if age < maxAge =>
        Seq(FarmTask(animal, "plowing", age))

      case animal @ Animal (_, age, Wolf) =>
        throw new Exception("Wolfs are attacking the farm!")

      case _ =>
        Seq()
    }
  }

}