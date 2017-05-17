package tree.chapter.contramap
import tree.chapter.contramap.PrintableThing.Printable

object PrintableImplicits {
  
  implicit val booleanPrinter: Printable[Boolean] = new Printable[Boolean] {
    def format(value: Boolean): String = if(value) "yes" else "no"
  }

  implicit val stringPrinter: Printable[String] = new Printable[String] {
    def format(value: String): String = value
  }

  implicit val intPrinter: Printable[Int] = new Printable[Int] {
    def format(value: Int): String = value.toString
  }

/*  implicit def boxPrinter[A, B](implicit p: Printable[A], f: B => A): Printable[Box[B]] = new Printable[Box[B]] {
    def format(box: Box[B]) = p.contramap(f).format(box.value)
  }*/

  implicit def boxPrinter[A](implicit p: Printable[A]): Printable[Box[A]] = {

    val x: ((Box[A]) => A) => Printable[Box[A]] = p.contramap[Box[A]]
    x(y => y.value)
  }
}
