
package two.chapter.monoids

import two.chapter.monoids._

object BooleanMonoids {

  implicit val andMonoid = new Monoid[Boolean] {
    def combine(x: Boolean, y: Boolean): Boolean = x && y
    def empty: Boolean = false
  }
  
  implicit val orMonoid = new Monoid[Boolean] {
    def combine(x: Boolean, y: Boolean): Boolean = x || y
    def empty: Boolean = false
  }
  
  implicit val equalMonoid = new Monoid[Boolean] {
    def combine(x: Boolean, y: Boolean): Boolean = x == y
    def empty: Boolean = false
  }
  
  implicit val notEqualMonoid = new Monoid[Boolean] {
    def combine(x: Boolean, y: Boolean): Boolean = x != y
    def empty: Boolean = false
  }
}
