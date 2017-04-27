package two.chapter.monoids

import two.chapter.monoids.SeqsMonoids._

object SetMonoidRunner extends App {

  println(s"the adding monoid of two sets is: ${Monoid[Set[Int]].combine(Set(1), Set(2))}")
  
}
