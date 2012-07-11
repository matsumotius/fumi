import org.scalatest.FunSuite
import scala.collection.mutable._
import com.myatsumoto.fumi.Fumi

class FumiSpec extends FunSuite {
  test("search") {
    val keys = "abcdr"
    val str  = "abracadabra"
    val fumi = new Fumi(str)

    keys.foreach(key =>
      fumi.search(key.toString).foreach(i =>
        assert(key == str(i))
      )
    )
    assert(-1 == fumi.search("x")(0))
  }
}
