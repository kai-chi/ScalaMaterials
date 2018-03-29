val myList: List[Int] = List(1, 2)

myList match {
  case List(a, b) =>
    a + b
}

myList match {
  case List(a, b, c) =>
    a + b
}

val myList: List[Int] = 1 :: 2 :: 3 :: 4 :: Nil

myList match {
  case a :: b :: rest =>
    println(rest); a + b
}

myList match {
  case a :: b :: Nil =>
    a + b
}

myList match {
  case a :: _ :: _ :: b :: Nil =>
    a + b
}

myList match {
  case a :: _ :: b :: _ =>
    a + b
}

val mySeq: Seq[Int] = Seq(1, 2, 3, 4)

mySeq match {
  case Seq(a, b) =>
    a + b
}

mySeq match {
  case Seq(a, b, _) =>
    a + b
}

mySeq match {
  case Seq(a, b, rest@_*) =>
    println(rest); a + b
}

