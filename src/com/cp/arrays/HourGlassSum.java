package com.cp.arrays;

/**
 * Input (stdin)
 * <p>
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * <p>
 * Expected Output
 * 19
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class HourGlassSum {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 0, 2, 4, 4, 0));
        arr.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        arr.add(Arrays.asList(0, 0, 1, 2, 4, 0));

        System.out.println(hourglassSum(arr));
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int hourglassSum = 0;
        int sum = 0;

        return hourglassSum;
    }
}
