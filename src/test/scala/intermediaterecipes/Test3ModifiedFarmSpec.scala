package intermediaterecipes

import intermediaterecipes.part2Testing.farm._
import org.scalacheck._
import org.specs2.ScalaCheck
import org.specs2.mock._
import org.specs2.mutable.Specification

class Test3ModifiedFarmSpec extends Specification with Mockito with ScalaCheck{
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

    "runs correctly for any number of days" in Prop.forAll(Gen.choose(0, 365)) { (days: Int) =>
      val tasker = mock[ModifiedFarmTasker]
      val farm = new ModifiedFarm("My Farm", tasker)

      val basicTask = FarmTask(chicken, "checking for eggs", 12)

      tasker.tasksForTheDay(anyInt) returns Seq(basicTask)

      val farmRun = farm.runForDays(13, days)
      farmRun must have size (days)
      farmRun.filter(_ == basicTask) must have size (days)
      there was days.times(tasker).tasksForTheDay(13)
    }
  }
}
