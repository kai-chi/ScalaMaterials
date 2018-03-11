import scala.annotation.tailrec

def fibonacciNaive(n: Int): Int = n match {
  case 0 => 0
  case 1 => 1
  case _ => fibonacciNaive(n - 1) + fibonacciNaive(n - 2)
}




fibonacciNaive(11)

def fibonacci(n: Int) = {
  @tailrec def fib(n: Int, prev: Int = 0, next: Int = 1): Int = n match {
    case 0 => prev
    case 1 => next
    case _ => fib(n - 1, next, (next + prev))
  }

  fib(n)
}

fibonacci(5)

def length (s: String) = s.length
def doIt(s: String, f: String => Int) = f(s)

doIt("abcdefgh", length)

