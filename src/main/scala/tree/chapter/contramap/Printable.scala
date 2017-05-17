
package tree.chapter.contramap

final case class Box[A](value: A)
object PrintableThing {

trait Printable[A] {
  def format(value: A): String

  def contramap[B](f: B => A): Printable[B] ={ 
  
  val self = this
  new Printable[B] {
    def format(value: B): String = {
      self.format(f(value))
    }
  }
}
}

def format[A](value: A)(implicit p: Printable[A]): String  = {
  p.format(value)
}
}
