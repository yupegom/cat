package one.chapter

trait Printable[A] {
  def format(input: A): String
}

