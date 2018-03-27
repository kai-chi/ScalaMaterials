val aPerson = new Person ("Antonio", "Canada")

trait Nameable {
  def name: String
}

trait Moveable {
  def moveTo(place: String): Unit
  def place: String
}

trait Placeable {
  def place: String
}

aPerson.place
aPerson.name

aPerson.moveTo("Australia")
aPerson.place

trait Moveable extends Placeable{
  def moveTo(place: String)
}

class Person(val name: String, var place: String) extends Nameable with Moveable {
  override def moveTo(newPlace: String): Unit = {
    this.place = newPlace
  }
}


