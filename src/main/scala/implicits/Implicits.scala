package implicits

object Implicits extends App{
  final case class Apple(weightInGrams: Int, color: String)
  final case class Orange(weightInGrams: Int)

  def function(orange: Orange): Unit = {
    println("-" * 50)
    println(orange)
    println("-" * 50)
  }

  object Bla {
    implicit def asdgergwret(apple: Apple): Orange =
      Orange(apple.weightInGrams)
  }

  import Bla._

  function(
    Apple(
      weightInGrams = 300,
      color = "red"
    )
  )
//
//  implicit def AppleWrapper(apple: Apple): AppleWrapper =
//    new AppleWrapper(apple)

  final implicit class AppleOps(private val self: Apple) extends AnyVal {
    def toOrange: Orange =
      Orange(self.weightInGrams)
  }

  function(
    Apple(
      weightInGrams = 300,
      color = "red"
    ).toOrange
  )

  final case class First(value: Int) extends AnyVal
  final case class Second(value: Int) extends AnyVal

  def method(a: Int)(implicit b: Int, c: Int): Int =
    a + b + c

  def method2(a: Int)(implicit b: First, c: Second): Int =
    a + b.value + c.value

  println("-" * 50)
  println(method(1)(2,3))

  implicit val whatever: First = First(4)
  implicit val whatever2: Second = Second(5)

  println(method2(1))
  println(method2(1)(First(4), Second(4)))

//  def getIt[It](it: It): It = it
//  def getIt[It](implicit it: It): It = it

  println(implicitly[First])
  println(implicitly[Apple => Orange])

  @scala.annotation.implicitNotFound(s"Give me an instance of SomeTypeClassFotType")
  trait SomeTypeClassForType[T] {
    def someMethod(t: T): Int
  }

  def algorithm[T](t: T)(implicit instance: SomeTypeClassForType[T]): Unit = {
    println(instance.someMethod(t))
  }

  def algorithm2[T: SomeTypeClassForType](t: T): Unit = {
    val instance = implicitly[SomeTypeClassForType[T]]
    println(instance.someMethod(t))
  }

  def algorithm3[T](t: T)(implicit convert: T => Int): Unit = {
    println(convert(t))
  }

  def algorithm4[T <% Int](t: T): Unit = {
    val convert = implicitly[T => Int]
    println(convert(t))
  }

  implicit object InstanceForStrings extends SomeTypeClassForType[String] {
    def someMethod(t: String): Int = 20
  }

//  implicit val instanceForString: SomeTypeClassForType[String] =
//    new SomeTypeClassForType[String] {
//      def someMethod(t: String): Int = 10
//    }

  algorithm("whatever")
  algorithm2("whatever")

//  implicit def conversion(x: String): Int = 123

  algorithm3(123)
  algorithm4(123)

  println("-" * 50)
}
