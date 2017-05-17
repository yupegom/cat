package tree.chapter.contramap

trait Codec[A] {
  def encode(value: A): String
  def decode(value: String): Option[A]

  def imap[B](dec: A => B, enc: B => A): Codec[B] = {
    val self = this
    new Codec[B] {
      def encode(value: B): String = self.encode(enc(value))
      def decode(value: String): Option[B] = self.decode(value).map(dec) 
    }
  }
}
