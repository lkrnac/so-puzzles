package net.lkrnac.sopuzzles;

import java.util.concurrent.TimeUnit;

import net.lkrnac.sopuzzles.minrainfall.Rainfall;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JmhMeasure {
  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(Rainfall.class.getSimpleName())
        .warmupIterations(5)
        .measurementIterations(5)
        .mode(Mode.AverageTime)
        .timeUnit(TimeUnit.NANOSECONDS)
        .forks(1)
        .build();

    new Runner(opt).run();
  }
}
