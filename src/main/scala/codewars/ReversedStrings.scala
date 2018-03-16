package codewars

object ReversedStrings {

  def solution(word: String): String =
    (for(i <- word.length -1 to 0 by -1) yield word(i)).mkString
}
