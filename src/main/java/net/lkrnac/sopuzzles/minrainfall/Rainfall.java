package net.lkrnac.sopuzzles.minrainfall;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.RunnerException;

/**
 * http://stackoverflow.com/a/32673753/1919879
 * 
 * @author Lubos Krnac
 *
 */
public class Rainfall {
  private static Map<String, Double> rainfallMap = new TreeMap<>();
  static {
    rainfallMap.put("January", 4.22);
    rainfallMap.put("February", 3.18);
    rainfallMap.put("March", 3.03);
    rainfallMap.put("April", 3.52);
    rainfallMap.put("May", 4.54);
    rainfallMap.put("June", 5.55);
    rainfallMap.put("July", 4.71);
    rainfallMap.put("August", 4.35);
    rainfallMap.put("September", 5.26);
    rainfallMap.put("October", 5.46);
    rainfallMap.put("November", 4.78);
    rainfallMap.put("December", 4.09);
  }

  public static void main(String[] args) throws RunnerException {
    Entry<String, Double> minEntry = getMinRaifallCollections();

    System.out.println(String.format("Minimal rainfall was %.2f in %s",
        minEntry.getValue(), minEntry.getKey()));
  }

  @Benchmark
  public static Entry<String, Double> getMinRaifallCollections() {
    return Collections.min(rainfallMap.entrySet(), Map.Entry.comparingByValue());
  }

  @Benchmark
  public static Entry<String, Double> getMinRainfallStreams() {
    return rainfallMap.entrySet().stream()
        .min((e1, e2) -> Double.compare(e1.getValue(), e2.getValue()))
        .get();
  }
}
