package roy

import org.scalatest._

trait MeterSuite {
  this: FlatSpec with MustMatchers =>

  def getM(): Meter

  "meter" should "inc" in {
    val m = getM()
    m.get() must be(0)
    m.inc()
    m.get() must be(1)
    m.inc()
    m.get() must be(2)
  }
}

class UBSpec extends FlatSpec with MustMatchers with MeterSuite {
  override def getM(): Meter = new UBMeter("id")
}

class DWSpec extends FlatSpec with MustMatchers with MeterSuite {
  override def getM(): Meter = new DWMeter("id")
}
