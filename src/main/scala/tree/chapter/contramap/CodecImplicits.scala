package tree.chapter.contramap

object CodecImplicits {
  implicit val booleanCodec: Codec[Boolean] = new Codec[Boolean] {
    def encode(value: Boolean): String = if(value) "yes" else "no"
    def decode(value: String): Option[Boolean] = value match {
      case "yes" => Option(true)
      case "no" => Option(false)
      case _ => None
    }
  }

  implicit def boxCodec[A](implicit c: Codec[A]): Codec[Box[A]] =
    c.imap[Box[A]](_.value) 
}
