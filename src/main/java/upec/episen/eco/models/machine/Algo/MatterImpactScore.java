package upec.episen.eco.models.machine.Algo;

import java.util.HashMap;
import java.util.Map;

public class MatterImpactScore {
       private static final Map<String, Integer> impactScores = new HashMap<>();
       private static final Map<String, Double> impactFactors = new HashMap<>();
       private static final Map<String, Double> averagePersonUsage = new HashMap<>();

       static {
              impactScores.put("Cobalt", 8);
              impactScores.put("Galvanized Steel", 6);
              impactScores.put("Glass", 2);
              impactScores.put("Gold", 9);
              impactScores.put("Copper", 5);
              impactScores.put("Rubber (tires)", 4);
              impactScores.put("Steel (spokes)", 6);
              impactScores.put("Polycarbonate", 5);
              impactScores.put("Maple Wood", 3);
              impactScores.put("Nichrome", 7);
              impactScores.put("ABS Plastic", 6);
              impactScores.put("Plastic", 5);
              impactScores.put("Steel", 6);
              impactScores.put("Stainless Steel", 7);
              impactScores.put("Magnesium", 7);
              impactScores.put("Leather or Fabric", 4);
              impactScores.put("Aluminum", 3);
              impactScores.put("Polyurethane Foam", 5);
              impactScores.put("Teflon Coating", 6);
              impactScores.put("Tempered Glass", 3);
              impactScores.put("Polyurethane", 5);
              impactScores.put("Nickel", 6);
              impactScores.put("Ceramic", 4);
              impactScores.put("Steel/Aluminum", 5);
              impactScores.put("Fiberglass", 4);
              impactScores.put("Rubber", 4);
              impactScores.put("Neodymium Magnets", 8);
              impactScores.put("Silicon", 4);
              impactScores.put("Rare Earths", 9);
              impactScores.put("Steel (carcass)", 6);
              impactScores.put("Ink", 3);
              impactScores.put("Lithium", 8);
              impactScores.put("Ferrite", 5);

              impactFactors.put("Cobalt", 0.02);
              impactFactors.put("Galvanized Steel", 0.012);
              impactFactors.put("Glass", 0.005);
              impactFactors.put("Gold", 0.03);
              impactFactors.put("Copper", 0.015);
              impactFactors.put("Rubber (tires)", 0.01);
              impactFactors.put("Steel (spokes)", 0.012);
              impactFactors.put("Polycarbonate", 0.009);
              impactFactors.put("Maple Wood", 0.002);
              impactFactors.put("Nichrome", 0.018);
              impactFactors.put("ABS Plastic", 0.008);
              impactFactors.put("Plastic", 0.008);
              impactFactors.put("Steel", 0.012);
              impactFactors.put("Stainless Steel", 0.014);
              impactFactors.put("Magnesium", 0.02);
              impactFactors.put("Leather or Fabric", 0.007);
              impactFactors.put("Aluminum", 0.01);
              impactFactors.put("Polyurethane Foam", 0.009);
              impactFactors.put("Teflon Coating", 0.011);
              impactFactors.put("Tempered Glass", 0.005);
              impactFactors.put("Polyurethane", 0.009);
              impactFactors.put("Nickel", 0.018);
              impactFactors.put("Ceramic", 0.006);
              impactFactors.put("Steel/Aluminum", 0.011);
              impactFactors.put("Fiberglass", 0.007);
              impactFactors.put("Rubber", 0.01);
              impactFactors.put("Neodymium Magnets", 0.025);
              impactFactors.put("Silicon", 0.004);
              impactFactors.put("Rare Earths", 0.04);
              impactFactors.put("Steel (carcass)", 0.012);
              impactFactors.put("Ink", 0.01);
              impactFactors.put("Lithium", 0.025);
              impactFactors.put("Ferrite", 0.012);

              averagePersonUsage.put("Plastic", 34000.0);
              averagePersonUsage.put("ABS Plastic", 5000.0);
              averagePersonUsage.put("Polyurethane", 2000.0);
              averagePersonUsage.put("Polyurethane Foam", 1500.0);
              averagePersonUsage.put("Aluminum", 24000.0);
              averagePersonUsage.put("Steel", 220000.0);
              averagePersonUsage.put("Stainless Steel", 14000.0);
              averagePersonUsage.put("Galvanized Steel", 14000.0);
              averagePersonUsage.put("Steel (carcass)", 30000.0);
              averagePersonUsage.put("Steel (spokes)", 5000.0);
              averagePersonUsage.put("Copper", 2200.0);
              averagePersonUsage.put("Gold", 0.1);
              averagePersonUsage.put("Lithium", 1.5);
              averagePersonUsage.put("Cobalt", 7.0);
              averagePersonUsage.put("Nickel", 800.0);
              averagePersonUsage.put("Rare Earths", 17.0);
              averagePersonUsage.put("Neodymium Magnets", 5.0);
              averagePersonUsage.put("Glass", 42000.0);
              averagePersonUsage.put("Tempered Glass", 5000.0);
              averagePersonUsage.put("Rubber", 8500.0);
              averagePersonUsage.put("Rubber (tires)", 7000.0);
              averagePersonUsage.put("Silicon", 50.0);
              averagePersonUsage.put("Ceramic", 3000.0);
              averagePersonUsage.put("Leather or Fabric", 10000.0);
              averagePersonUsage.put("Ferrite", 10.0);
              averagePersonUsage.put("Maple Wood", 5000.0);
              averagePersonUsage.put("Magnesium", 100.0);
              averagePersonUsage.put("Fiberglass", 500.0);
              averagePersonUsage.put("Polycarbonate", 500.0);
              averagePersonUsage.put("Nichrome", 5.0);
              averagePersonUsage.put("Teflon Coating", 50.0);
              averagePersonUsage.put("Ink", 100.0);
       }

       public static int getImpactScore(String material) {
              return impactScores.getOrDefault(material, 5);
       }

       public static double getImpactFactor(String material) {
              return impactFactors.getOrDefault(material, 0.01);
       }

       public static double getAverageUsage(String material) {
              return averagePersonUsage.getOrDefault(material, 1000.0);
       }

       public static double calculateUsageAdjustment(Map<String, Double> materialUsage) {
              final double[] volumeAdjustment = {0};

              materialUsage.forEach((material, usage) -> {
                     double average = getAverageUsage(material);

                     if (usage > average) {
                            double excessRatio = usage / average;
                            volumeAdjustment[0] -= Math.log10(excessRatio) * 0.5;
                     } else {
                            double savingRatio = average / Math.max(usage, 1);
                            volumeAdjustment[0] += Math.log10(savingRatio) * 0.2;
                     }
              });

              return Math.max(-5, Math.min(3, volumeAdjustment[0]));
       }
}
