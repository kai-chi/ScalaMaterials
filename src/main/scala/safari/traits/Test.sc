import safari.{Boat, Plane}

trait Vehicle {
  def launch
}

trait Boat extends safari.Vehicle {
  override def launch = println("I'm a boat")
}

trait Boat2 extends safari.Vehicle {
  override def launch = println("I'm another boat")
}

trait Plane extends safari.Vehicle {
  override def launch = println("I'm a plane")
}

class Seaplane extends Plane with Boat {

}

val s = new Seaplane

s.launch

val s1 = new Seaplane with Boat2

s1.launch