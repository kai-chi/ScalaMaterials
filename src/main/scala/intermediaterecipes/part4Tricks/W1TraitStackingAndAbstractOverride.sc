trait Animal {
  def liveOneDay: Seq[String] = Seq("walk")
}

trait AttackingAnimal extends Animal {
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "attack farm"
}

(new Wolf).liveOneDay

trait CarnivoreAnimal extends Animal {
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "eat animal"
}

(new Fox).liveOneDay
// what if I want to borrow some functionality
// form wolf? I can't extend Wolf bc a fox is not a wolf

trait HenAttackerAnimal extends Animal {
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "attack henhouse"
}

trait Animal2 {
  def liveOneDay: Seq[String]
}

trait FlyingAnimal2 extends Animal2 {
  abstract override def liveOneDay: Seq[String] = super.liveOneDay :+ "fly"
}

trait CarnivoreAnimal2 extends Animal2 {
  abstract override def liveOneDay: Seq[String] = super.liveOneDay :+ "eat animal"
}

(new Wolf2).liveOneDay

trait EmptyAnimal2 extends Animal2 {
  override def liveOneDay: Seq[String] = Seq.empty
}

(new Fox2).liveOneDay

// what if I want to create a crow that can eat an animal
// but cannot walk?

class Wolf extends Animal {
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "attack farm" :+ "eat animal"
}
// ugh, this guy walks :/

class Fox extends Animal {
  override def liveOneDay: Seq[String] = super.liveOneDay :+ "attack farm" :+ "eat animal" :+ "eat henhouse"
}
// this is better
// let's add a raven

// ok basically we have to abstract the liveOneDay function

class Wolf2 extends Animal with CarnivoreAnimal with AttackingAnimal

class Fox2 extends Animal with AttackingAnimal with CarnivoreAnimal with HenAttackerAnimal
// what we are saying here is that someone will somewhere provide
// the implemenetation of Animal2.liveOneDay

class Crow extends Animal {
  override def liveOneDay = super.liveOneDay :+ "fly"
}

//class Raven extends Animal2 with FlyingAnimal2 with CarnivoreAnimal2
// the line above will not compile since we have no implementation
// of liveOneDay
// let's create a trait with it

class Crow2 extends Animal {
  override def liveOneDay = Seq("fly")
}

class Raven extends Animal2 with EmptyAnimal2 with FlyingAnimal2 with CarnivoreAnimal2

(new Raven).liveOneDay
// we could have avoided it by providing a basic implementation
// in Animal2 class, i.e. returning Seq.empty
// our approach has some benefits tho - Animal2 is a clean interface
// and you choose your implementation details
