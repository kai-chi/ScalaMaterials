package intermediaterecipes

import intermediaterecipes.part2Testing.farm._
import org.specs2.mock._
import org.specs2.mutable.Specification

class Test3ModifiedFarmSpec extends Specification with Mockito {
  "ModifiedFarm" should {
    val chicken = Animal("Bob", 12, Chicken)
    val cow = Animal("Bessy", 12, Cow)
    val horse = Animal("Douglas", 12, Horse)
    val dog = Animal("Douglas", 12, Dog)
    val cat = Animal("Douglas", 12, Cat)


    "runs correctly for one day" in {
      val tasker = mock[ModifiedFarmTasker]
      val farm = new ModifiedFarm("My Farm", tasker)

      tasker.tasksForTheDay(13) returns Seq(
        FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
        FarmTask(horse, "plowing", 12)
      )

      farm.runForDays(13, 1) must_== Seq(
        FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
        FarmTask(horse, "plowing", 12)
      )
      there was one(tasker).tasksForTheDay(13)
    }

    "runs correctly for two days" in {
      val tasker = mock[ModifiedFarmTasker]
      val farm = new ModifiedFarm("My Farm", tasker)

      tasker.tasksForTheDay(13) returns Seq(
        FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
        FarmTask(horse, "plowing", 12)
      )

      farm.runForDays(13, 2) must_== Seq(
        FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
        FarmTask(horse, "plowing", 12),
        FarmTask(chicken, "checking for eggs", 12),
        FarmTask(cow, "milking", 12),
        FarmTask(horse, "plowing", 12)
      )
      there was 2.times(tasker).tasksForTheDay(13)
    }

  }
}
