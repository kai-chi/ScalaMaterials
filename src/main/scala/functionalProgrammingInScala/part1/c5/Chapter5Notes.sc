def if2[A](cond: Boolean, onTrue: => A, onFalse: => A): A =
  if (cond) onTrue else onFalse

if2(false, sys.error("fail"), 3)

def maybeTwice(b: Boolean, i: => Int)= if (b) i+i else 0

maybeTwice(true, {println("hi"); 1 + 41})

//we can cache the value explicitly by using the lazy keyword

def maybeTwice2(b: Boolean, i: => Int)= {
  lazy val j = i
  if (b) j+j else 0
}

maybeTwice2(true, {println("hi"); 1 + 41})

