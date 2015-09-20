package net.lkrnac.sopuzzles.minrainfall;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * http://stackoverflow.com/a/32673753/1919879
 * 
 * @author Lubos Krnac
 *
 */
public class Rainfall {
  String[] months = { "January", "February", "March", "April", "May",
      "June", "July", "August", "September",
      "October", "November", "December" };
  double[] rainfall = { 4.22, 3.18, 3.03, 3.52, 4.54, 5.55,
      4.71, 4.35, 5.26, 5.46, 4.78, 4.09 };

  public static void main(String[] args) {
    Map<String, Double> rainfallMap = new HashMap<>();
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

    Entry<String, Double> minEntry = rainfallMap.entrySet().stream()
        .min((e1, e2) -> Double.compare(e1.getValue(), e2.getValue()))
        .get();

    System.out.println(String.format("Minimal rainfall was %.2f in %s",
        minEntry.getValue(), minEntry.getKey()));
  }
}
