package intermediaterecipes

import intermediaterecipes.part2Testing.farm._
import org.specs2.mutable.Specification

class FarmSpec extends Specification {
  "Farm" should {
    val farm = Farm("My Farm")

    "extract the proper tasks for a chicken" in {
      val chicken = Animal("Bob", 12, Chicken)

      farm.tasksForTheDay(Seq(chicken)) must_== Seq(FarmTask(chicken, "checking for eggs"))
    }

    "extract the proper tasks for a cow" in {
      val cow = Animal("Bessy", 12, Cow)

      farm.tasksForTheDay(Seq(cow)) must_== Seq(FarmTask(cow, "milking"))
    }

    "extract the proper tasks for a horse" in {
      val horse = Animal("Douglas", 12, Horse)

      farm.tasksForTheDay(Seq(horse)) must_== Seq(FarmTask(horse, "plowing"))
    }

    "extract no tasks for a dog or a cat" in {
      val dog = Animal("Cleo", 12, Dog)
      val cat = Animal("Santiago", 12, Cat)

      farm.tasksForTheDay(Seq(dog)) must beEmpty
      farm.tasksForTheDay(Seq(cat)) must beEmpty
    }

    "extract all tasks for multiple animals" in {
      val chicken = Animal("Bob", 12, Chicken)
      val cow = Animal("Bessy", 12, Cow)
      val horse = Animal("Douglas", 12, Horse)

      farm.tasksForTheDay(Seq(chicken, cow, horse)) must_==
        Seq(FarmTask(chicken, "checking for eggs"),
          FarmTask(cow, "milking"),
          FarmTask(horse, "plowing"))
    }
  }
}
