package roy

import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations._

@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode(Array(Mode.Throughput))
@State(Scope.Benchmark)
class MeterBench {

  val dwM = new DWMeter("id")
  val ubM = new UBMeter("id")

  @Benchmark
  def DWinc(): Unit = {
    dwM.inc()
  }

  @Benchmark
  def UBinc(): Unit = {
    ubM.inc()
  }
}
