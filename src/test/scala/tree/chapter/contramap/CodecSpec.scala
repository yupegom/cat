package tree.chapter.contramap
import tree.chapter.contramap.Codec._
import org.scalatest._

class CodecSpec extends FlatSpec with Matchers {
  "Codec" should "encode a boolean" in {
    import tree.chapter.contramap.CodecImplicits.booleanCodec
    encode(true) shouldBe "yes"
  }

  "Codec" should "decode a boolean" in {
    import tree.chapter.contramap.CodecImplicits.booleanCodec
    decode("yes") shouldBe Some(true)
  }

  "Codec" should "not decode an invalid input" in {
    import tree.chapter.contramap.CodecImplicits.booleanCodec
    decode("y") shouldBe None
  }
}
