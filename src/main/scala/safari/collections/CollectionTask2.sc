def returnNth[A](list: List[A], n: Int): A = n match {
  case 0 => list.head
  case k if k > 0 && k < list.length => returnNth(list.tail, k - 1)
  case _ => throw new IndexOutOfBoundsException()
}

def removeNth[A](list: List[A], n: Int) = {
  list.take(n) ::: list.drop(n + 1)
}

val list = List(0, 1, 2, 3, 4, 5)
returnNth(list, 4)

removeNth(list, 2)

