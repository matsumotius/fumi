import org.scalatest.FunSuite
import scala.collection.mutable._
import com.myatsumoto.fumi.Bwt

class BwtSpec extends FunSuite {
  test("transform") {
    val str = "abracadabra"
    val bwt = new Bwt(str)
    assert(bwt.last == "rdarcaaaabb")
  }
}
