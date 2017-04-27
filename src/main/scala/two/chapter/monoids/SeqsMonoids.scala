package two.chapter.monoids

object SeqsMonoids {
  
  implicit def  addSet[A] = new Monoid[Set[A]] {
    def combine(x: Set[A], y: Set[A]): Set[A] = x ++ y
    def empty: Set[A] = Set()
  }
}
