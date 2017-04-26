package two.chapter.monoids

import two.chapter.monoids.BooleanMonoids.andMonoid
import two.chapter.monoids.Monoid._
object BooleanMonoidsTest extends App {

 println(s"this boolean combine is true ${Monoid[Boolean].combine(false, true)}") 

}
