package two.chapter.adder

import cats.Monoid
import cats.syntax.semigroup._
import cats.instances.int._
import cats.instances.option._
// import cats.instances.list._
object SuperAdder extends App {
  def addItems(items: List[Int]): Int = {
    items.foldLeft(Monoid[Int].empty)((b, a) => b |+| a)
  }

  def addItemsOption(items: List[Option[Int]]): Option[Int] = {

    items.foldLeft(Monoid[Option[Int]].empty)((b, a) => b |+| a)
  }


  println(addItems(List(1, 2, 6, 10)))
}
