package vggames.scala.specs.string

import vggames.scala.specs.GameSpecification
import vggames.scala.code.RestrictedFunction1

class ReverseStrings extends GameSpecification[RestrictedFunction1[String, String]] {

  def runSignature = "(a:String):String"

  def extendsType = "RestrictedFunction1[String, String]"

  def getChallenge = """Inverta a string <code>a</code>"""

  "O seu código" should {
    """ inverter "abc" e produzir "cba" """ in {
      code("abc") must_== "cba"
    }

    """ inverter "arara" e produzir "arara" """ in {
      code("arara") must_== "arara"
    }

    """ inverter "orrac" e produzir "carro" """ in {
      code("orrac") must_== "carro"
    }
  }

}