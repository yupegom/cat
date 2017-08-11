package state

import org.scalatest._
import state.PostOrderCalc._

class PostOrderCalcSpec extends FlatSpec with Matchers {
  
  "A PostOrderCalc" should "return the value if we evaluate an empty list" in {
    evalOne("42").runA(Nil).value shouldBe 42
  }

  it should "return the correct result for a sequence of valid values and operators" in {
    val program = for {
      _ <- evalOne("1")
      _ <- evalOne("2")
      ans <- evalOne("+")
    }yield ans

    program.runA(Nil).value shouldBe 3
  }
}
