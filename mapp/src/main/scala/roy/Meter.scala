package roy

sealed trait Meter {
  def inc(): Unit

  def get(): Long
}

class UBMeter(id: String) extends Meter {
  val reporter: io.ultrabrew.metrics.Reporter =
    (_: io.ultrabrew.metrics.Metric, _: Long, value: Long, _: Array[String]) =>
      count = count + value
  private val metricRegistry = new io.ultrabrew.metrics.MetricRegistry()
  private val counter: io.ultrabrew.metrics.Counter = metricRegistry.counter(id)
  private var count: Long = 0L
  metricRegistry.addReporter(reporter)

  override def inc(): Unit = counter.inc()

  override def get(): Long = count
}

class DWMeter(id: String) extends Meter {
  private val metricRegistry = new com.codahale.metrics.MetricRegistry()
  private val counter: com.codahale.metrics.Counter = metricRegistry.counter(id)

  override def inc(): Unit = counter.inc()

  override def get(): Long = counter.getCount
}
