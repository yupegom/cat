
package tree.chapter

import org.scalatest._
import cats.syntax.functor._
import tree.chapter.TreeFunctor._

class TreeFunctorSpec extends FlatSpec with Matchers {
  "A TreeFunctor" should "apply a map function by2 to a Leaf" in {
    val tree: Tree[Int] = Leaf(2)
    val treeBy2 = tree.map(_*2)
    treeBy2 shouldBe Leaf(4)
  }

  "A TreeFunctor" should "apply a map function by2 to a tree with 2 leafs" in {
    val tree: Tree[Int] = Branch(Leaf(2), Leaf(3))
    val treeBy2 = tree.map(_*2)
    treeBy2 shouldBe Branch(Leaf(4), Leaf(6))
  }

  "A TreeFunctor" should "apply a map function by2 to a tree with 1 branch and 2 leafs" in {
    val tree: Tree[Int] = Branch(Branch(Leaf(2), Leaf(3)), Leaf(2))
    val treeBy2 = tree.map(_*2)
    treeBy2 shouldBe Branch(Branch(Leaf(4), Leaf(6)), Leaf(4))
  }

  "A TreeFunctor" should "apply a map function transforming a Leaf to a branch of two leafs" in {
    val tree: Tree[Int] = Leaf(2)
    val treeBy2: Tree[Tree[Int]] = tree.map(t => Branch(Leaf(t), Leaf(t)))
    treeBy2 shouldBe Leaf(Branch(Leaf(2), Leaf(2)))
  }
}


