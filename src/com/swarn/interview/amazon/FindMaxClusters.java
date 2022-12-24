package com.swarn.interview.amazon;

import java.util.Arrays;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class FindMaxClusters {

    public static void main(String[] args) {
        List<Integer> pp = Arrays.asList(203, 105, 530, 3567, 1092, 3);
        List<Integer> bp = Arrays.asList(992, 1453, 854, 152, 2377, 4);
        int maxPower = 15;
        //print(pp, bp, maxPower);
        System.out.println(findMaximumSustainableClusterSize(pp, bp, maxPower));
    }

    public static void print(List<Integer> processingPower, List<Integer> bootingPower, long powerMax) {

    }

    public static int findMaximumSustainableClusterSize(List<Integer> processingPower, List<Integer> bootingPower, long powerMax) {
        System.out.println("PP : " + processingPower.toString());
        System.out.println("BP : " + bootingPower.toString());
        System.out.println("Power Max : " + powerMax);

        int clusterSize = 0;

        for (int i = 1; i <= processingPower.size(); i++) {
            int maxBootingPower = 0;
            int sumOfPP = 0;

            for (int j = 0; j <= processingPower.size(); j++) {
                if (maxBootingPower < bootingPower.get(j)) {
                    maxBootingPower = bootingPower.get(j);
                }
                sumOfPP += processingPower.get(j);
            }

            float netConsumption = maxBootingPower + (sumOfPP * i);
            if (netConsumption <= powerMax) {
                clusterSize = i;
            }
        }
        return clusterSize;
    }
}
