val myListBuilder = List.newBuilder[Int]

myListBuilder += 5

myListBuilder ++= Seq(1,2,3,4,5)

myListBuilder.result()

val myVectorBuilder = Vector.newBuilder[Int]

myVectorBuilder += 5
myVectorBuilder ++= Seq(1,2,3,4,5)

myVectorBuilder.result()