package codewars

import org.scalatest.{FlatSpec, Matchers}

class ReversedStringsTest extends FlatSpec with Matchers {

  "String" should "be empty" in {
    val res = ReversedStrings.solution("")
    res should be ("")
  }

  it should "be the same" in {
    val res = ReversedStrings.solution("11111")
    res should be ("11111")
  }

  it should "be the same as well" in {
    val res = ReversedStrings.solution("12321")
    res should be ("12321")
  }

  it should "be reversed" in {
    val res = ReversedStrings.solution("abcde")
    res should be ("edcba")
  }

  it should "be reversed as well" in {
    val res = ReversedStrings.solution("world")
    res should be ("dlrow")
  }

}
