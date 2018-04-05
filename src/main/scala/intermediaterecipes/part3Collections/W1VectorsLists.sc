val a = List(1, 2, 3)

a :+ 4

a

val myLongList = (1 to 100000).toList

0 :: myLongList

myLongList :+ 0

val myLongList1 = (1 to 1000000).toList

0 :: myLongList1

myLongList1 :+ 0

val myLongVector = (1 to 10000000).toVector

myLongVector :+ 0

0 +: myLongVector
// vector works different. it allocates big chunks of data
//it builds a trie and uses it to find elements

myLongList1(500000)
myLongVector(5000000)
//vector is very good in look up any element
//list is not bad either but it's so bad in adding an element
// bc it has to perform a lot of copping

myLongVector.slice(5000, 5005)

myLongVector.patch(5000, Seq(1,2,3,4,5), 5)

myLongVector.slice(5000, 5005)

res13.slice(4999, 5006)

myLongVector.patch(5000, Seq(1,2,3,4,5), 1)
res16.slice(4999, 5006)
//patch gives us the ability to replace a piece
//in the middle or even insert a piece in the middle

myLongVector.patch(5000, Seq(1,2,3,4,5), 10)
res18.slice(4999, 5006)


