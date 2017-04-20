package one.chapter

final case class Cat(
  name: String, 
  age: Int,
  color: String
)

object Formaters {
  
  implicit val stringFormater = new Printable[String] {
    def format(value: String) = value
  }

  implicit val intFormater = new Printable[Int] {
    def format(value: Int) = value.toString
  }

  implicit val catFormater = new Printable[Cat] {
    def format(value: Cat) = s"${value.name} is a ${value.age} year-old ${value.color} cat." 
  }
}
