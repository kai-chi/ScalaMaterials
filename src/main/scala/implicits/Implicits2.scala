package implicits

object Imports {
  implicit def appleToOrange1(apple: Apple): Orange =
    Orange("1")
}

final case class Apple(message: String)

final case class Orange(message: String) {
  final override def toString: String =
    message
}

object Apple {
  implicit def appleToOrange4(apple: Apple): Orange =
    Orange("4")
}

trait Ancestor {
//  implicit def appleToOrange3(apple: Apple): Orange =
//    Orange("3")
}

object Implicits2 extends App with Ancestor {
  println("-" * 50)

//  implicit def appleToOrange2(apple: Apple): Orange =
//    Orange("2")

  {
//    implicit def appleToOrange1(apple: Apple): Orange =
//      Orange("1")


    val orange: Orange = Apple("whatever")

    println(orange)
  }
  println("-" * 50)
}
