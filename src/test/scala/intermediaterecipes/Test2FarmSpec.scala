package intermediaterecipes

import intermediaterecipes.part2Testing.farm._
import org.specs2.matcher.Matcher
import org.specs2.mutable.Specification

class Test2FarmSpec extends Specification {
  "Farm" should {
    val farm = Farm("My Farm")

    def performATask(description: String): Matcher[FarmTask] = { task: FarmTask =>
      task.description == description
    }

    "extract the proper tasks for a chicken" in {
      val chicken = Animal("Bob", 12, Chicken)

      farm.tasksForTheDay(Seq(chicken)) must_== Seq(FarmTask(chicken, "checking for eggs", 12))
    }

    "extract the proper tasks for a cow" in {
      val cow = Animal("Bessy", 12, Cow)

      farm.tasksForTheDay(Seq(cow)) must_== Seq(FarmTask(cow, "milking", 12))
    }

    "extract the proper tasks for a horse" in {
      val horse = Animal("Douglas", 12, Horse)

      farm.tasksForTheDay(Seq(horse)).head must performATask("plowing")
      farm.tasksForTheDay(Seq(horse)) must_== Seq(FarmTask(horse, "plowing", 12))
    }

    "extract no tasks for a dog or a cat" in {
      val dog = Animal("Cleo", 12, Dog)
      val cat = Animal("Santiago", 12, Cat)

      farm.tasksForTheDay(Seq(dog)) must have size 0
      farm.tasksForTheDay(Seq(dog)) must beEmpty
      farm.tasksForTheDay(Seq(cat)) must beEmpty
    }

    "extract all tasks for multiple animals" in {
      val chicken = Animal("Bob", 12, Chicken)
      val cow = Animal("Bessy", 12, Cow)
      val horse = Animal("Douglas", 12, Horse)

      farm.tasksForTheDay(Seq(chicken, cow, horse)) must_==
        Seq(FarmTask(chicken, "checking for eggs", 12),
          FarmTask(cow, "milking", 12),
          FarmTask(horse, "plowing", 12))
    }

    "extract the correct task descriptions for multiple animals" in {
      val chicken = Animal("Bob", 12, Chicken)
      val cow = Animal("Bessy", 12, Cow)
      val horse = Animal("Douglas", 12, Horse)

      farm.tasksForTheDay(Seq(chicken, cow, horse)) must have size 3
      farm.tasksForTheDay(Seq(chicken, cow, horse)) must beLike {
        case Seq(FarmTask(_, chickenDescription, _), FarmTask(_, cowDescription, _), FarmTask(_, horseDescription, _)) =>
          chickenDescription must_== "checking for eggs"
          cowDescription must_== "milking"
          horseDescription must_== "plowing"
      }
    }

    "contain all tasks for multiple animals" in {
      val chicken = Animal("Bob", 12, Chicken)
      val cow = Animal("Bessy", 12, Cow)
      val horse = Animal("Douglas", 12, Horse)

      farm.tasksForTheDay(Seq(chicken, cow, horse)) must contain(
        FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
        FarmTask(horse, "plowing", 12)
      )
    }

    "assigns ages as the duration of each task" in {
      val chicken = Animal("Bob", 12, Chicken)
      val cow = Animal("Bessy", 12, Cow)
      val horse = Animal("Douglas", 12, Horse)

      farm.tasksForTheDay(Seq(chicken)).map(_.duration) must contain(12)
      farm.tasksForTheDay(Seq(cow)).map(_.duration) must contain(be_>=(11))
      farm.tasksForTheDay(Seq(horse)).map(_.duration) must contain(be_<=(13))
    }

    "assigns animals as the animal of each task" in {
      val chicken = Animal("Bob", 12, Chicken)

      farm.tasksForTheDay(Seq(chicken)).map(_.animal) must contain(beAnInstanceOf[Animal])
    }

    "throws an exception if trying to find the task for a wolf" in {
      val wolf = Animal("Jack", 12, Wolf)

      farm.tasksForTheDay(Seq(wolf)) must throwAn[Exception]
    }
  }
}
