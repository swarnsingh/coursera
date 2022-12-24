package com.swarn.coursera.algorithmtoolbox.week6;

import com.swarn.coursera.util.FastScanner;

import java.util.*;

/**
 * You and two of your friends have just returned back home after visiting various countries.
 * Now you would like to evenly split all the souvenirs that all three of you bought.
 * <p>
 * Problem Description
 * Input Format. The first line contains an integer 𝑛. The second line contains integers 𝑣1 , 𝑣2 , . . . , 𝑣𝑛
 * separated by spaces.
 * Constraints. 1≤𝑛≤20,1≤𝑣𝑖 ≤30for all 𝑖.
 * Output Format. Output 1, if it possible to partition 𝑣1, 𝑣2, . . . , 𝑣𝑛 into three subsets with equal sums, and
 * 0 otherwise.
 * Sample 1.
 * Input:
 * 4
 * 3 3 3 3
 * Output:
 * 0
 * <p>
 * Sample 2.
 * Input:
 * 1
 * 40
 * Output:
 * 0
 * <p>
 * Sample 3.
 * Input:
 * 11
 * 17 59 34 57 17 23 67 1 18 2 59
 * Output:
 * 1
 * <p>
 * 34 + 67 + 17 = 23 + 59 + 1 + 17 + 18 = 59 + 2 + 57.
 * <p>
 * Sample 4.
 * Input:
 * 13
 * 1 2 3 4 5 5 7 7 8 10 12 19 25
 * Output:
 * 1
 * 1 + 3 + 7 + 25 = 2 + 4 + 5 + 7 + 8 + 10 = 5 + 12 + 19.
 */

/**
 * @author Swarn Singh.
 */
public class Partition3 {
    private static int partition3(Integer[] souvenirs, int subsetValue) {
        Arrays.sort(souvenirs, Collections.reverseOrder());
        int subset = 3;

        while (subset > 0) {
            subset--;
            Integer tempSubset = 0;
            for (int i = 0; i < souvenirs.length; i++) {
                Integer val = souvenirs[i];
                if (val != 0) {
                    Integer temp = tempSubset + val;
                    if (temp == subsetValue) {
                        souvenirs[i] = 0;
                        break;
                    } else if (i == souvenirs.length - 1) {
                        return 0;
                    } else if (temp < subsetValue) {
                        tempSubset = temp;
                        souvenirs[i] = 0;
                    } else if (temp > subsetValue) {
                        continue;
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        Integer[] A = new Integer[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
            total += A[i];
        }
        if (total % 3 == 0) {
            System.out.println(partition3(A, total / 3));
        } else {
            System.out.println(0);
        }
    }
}

