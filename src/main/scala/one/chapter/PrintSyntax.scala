package one.chapter

object PrintSyntax {
  def format[A](value: A)(implicit formater: Printable[A]): String = {
    formater.format(value)
  }

  def print[A](value: A)(implicit formater: Printable[A]): Unit = {
    println(format(value))
  }

  implicit class PrintOps[A](value: A) {
    def format(implicit formater: Printable[A]): String =
      formater.format(value)
    def print(implicit formater: Printable[A]): Unit =
      println(PrintOps(value).format)
  }
}
