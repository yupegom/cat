package tree.chapter

import cats.Functor

object TreeFunctor {

  implicit val functor: Functor[Tree] = new Functor[Tree]{
    def map[A, B](value: Tree[A])(func: A => B): Tree[B] = {
      value match {
        case Leaf(v) => Leaf(func(v))
        case Branch(l, r) => Branch(map(l)(func), map(r)(func))
      }
    }
  }
}
