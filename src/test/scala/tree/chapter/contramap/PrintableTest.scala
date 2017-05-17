package tree.chapter.contramap

import org.scalatest._
import tree.chapter.contramap.PrintableThing._

class PrintableTest extends FlatSpec with Matchers {
  "A Printable" should "print a boolean" in {
    import tree.chapter.contramap.PrintableImplicits.booleanPrinter
    format(true) shouldBe "yes"
  }

  it should "print the int inside a box " in {
    import tree.chapter.contramap.PrintableImplicits.boxPrinter
    import tree.chapter.contramap.PrintableImplicits.intPrinter

//    implicit def y: Int => Boolean = value => if(value > 3) true else false

    format(Box(5)) shouldBe "5"

  }

  it should "print the int inside a Box[Int]" in {
    import tree.chapter.contramap.PrintableImplicits.boxPrinter
    import tree.chapter.contramap.PrintableImplicits.intPrinter

//    implicit def y: Int => Boolean = value => if(value > 3) true else false

    format(Box(2)) shouldBe "2"

  }

  it should "print a boolean false from a Box[Int]" in {
    import tree.chapter.contramap.PrintableImplicits.boxPrinter
    import tree.chapter.contramap.PrintableImplicits.booleanPrinter

//    implicit def y: Int => Boolean = value => if(value > 3) true else false

    format(Box(true)) shouldBe "yes"

  }
}
