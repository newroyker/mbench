# mbench:
metrics lib microbench

### mapp
* Test:
`sbt mapp/test`

# Coverage:
* Runs tests: `sbt clean coverage test`
* Generate report: `sbt coverageReport`
* Display `mapp` report: `open mapp/target/scala-2.12/scoverage-report/index.html`

### mbench
* Depends on `mapp`
* Benchmark:
`sbt "mbench/jmh:run -i 3 -wi 1 -f 1 -t 1 .*Bench.*"`

### TL;DR
```text
[info] REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
[info] why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
[info] experiments, perform baseline and negative tests that provide experimental control, make sure
[info] the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
[info] Do not assume the numbers tell you what you want them to tell.
[info] Benchmark          Mode  Cnt          Score          Error  Units
[info] MeterBench.DWinc  thrpt    3  125926108.999 ± 47553569.012  ops/s
[info] MeterBench.UBinc  thrpt    3   31143982.887 ±  5337957.107  ops/s
```
