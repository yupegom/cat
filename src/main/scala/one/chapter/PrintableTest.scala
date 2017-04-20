package one.chapter

import one.chapter.Formaters._
import one.chapter.PrintSyntax._


object PrintableTest extends App {

  val cat = Cat("pimpis", 10, "black")
  PrintSyntax.print[Cat](cat)
  cat.print
}
