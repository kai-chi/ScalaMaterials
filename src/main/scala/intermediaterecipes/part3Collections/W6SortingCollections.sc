import java.time.LocalDateTime

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

Seq(4, 6, 1, 2, 9, 12, 3)

Seq(4, 6, 1, 2, 9, 12, 3).sorted

Vector(4, 6, 1, 2, 9, 12, 3).sorted

animals.sortWith(_.age < _.age)
//sortWith is stable

animals.sortBy(_.age)

implicit val animalOrdering: Ordering[Animal] = Ordering.by[Animal, Int](_.age)

animals.sorted

val firstDate = LocalDateTime.now
val secondDate = LocalDateTime.now

val dateList = Seq(secondDate, firstDate)

implicit val dateTimeOrdering: Ordering[LocalDateTime] = Ordering.fromLessThan[LocalDateTime](_ isBefore _)
dateList.sorted
//reverse order
implicit val dateTimeOrdering: Ordering[LocalDateTime] = Ordering.fromLessThan[LocalDateTime](_ isAfter _)
dateList.sorted
