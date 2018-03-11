val people = List (
  List("dave", "paul"),
  List(),
  List("jane"),
  List("liz", "bill")
)

val lst = List(1, 2, 3, 4)

lst.filter(n => n%2 == 0)

lst.map(n => n + 2)
lst.map(_+2)

val people2 = people.flatten.map(s => s.capitalize)

val people3 = people.flatMap(c => c.map(s => s.capitalize))
val people4 = people.flatMap(_.map(_.capitalize))

val strings = List("ab", 41, "ef")

//collect is like map but ignores things that don't fit
val caps = strings.collect(
  { case s: String => s.capitalize }
)

val result = lst.foldLeft(1)(
  (acc, nxt) => acc * nxt
)

val str = List("ab", "cd", "ef")
val s= str.foldLeft("")((a,b) => a+b)
val s1= str.foldRight("")((a,b) => a+b)

val result2 = lst.reduce((a,b) => a+b)
val result3 = lst.reduce(_+_)

def contains[A](lst: List[A], item: A) = {
  lst.foldLeft(false)((a,b) => a || b == item)
}

contains(lst , 12)

def reverse[A](lst: List[A]) : List[A] =
  lst.foldLeft(List[A]())((a,b) => b :: a)

reverse(lst)

val ppl = Map("dave" -> 42, "paul" -> 41)
val d = ppl("dave")
val b = ppl.get("brian")
val j = ppl.getOrElse("jill", 0)

ppl.contains("dave")
ppl.isDefinedAt("dave")

val ppl2 = ppl + ("bill" -> 55, "ann" -> 33)

val ppl3 = Map("dave" -> 22, "jane" -> 30)

val ppl4 = ppl ++ ppl3

for( (k,v) <- ppl; i <- 1 to 4)
  println(k)

for((name, age) <- ppl2 if age > 40)
  println(name)

for(x <- 1 to 4; y <- 2 to 3)
  print(x+y)

(1 to 4).foreach(x => (2 to 3).foreach(y => println(x+y)))

val prices = List(
  List(1000, 700, 900),
  List(),
  List(500, 2100)
)

//for comprehension
for {
  pr <- prices
  p <- pr
  if p >= 1000
} yield p + 0.1*p

prices.flatMap(pr => pr.filter(p => p>=1000).map(p => p+p*0.1))