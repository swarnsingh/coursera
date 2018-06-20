package com.coursera.algorithmtoolbox.week3;

import com.coursera.util.FastScanner;

/**
 * Problem Description
 *
 * Task. The goal in this problem is to find the minimum number of coins needed to change the input value (an integer) into coins with denominations 1, 5, and 10.
 * Input Format. The input consists of a single integer 𝑚.
 * Constraints. 1 ≤ 𝑚 ≤ 10 * 10 * 10.
 *
 * Output Format. Output the minimum number of coins with denominations 1, 5, 10 that changes 𝑚.
 *
 * Sample 1.
 *      Input:
 *          2
 *      Output:
 *          2
 *
 *          2 = 1 + 1.
 *
 * Sample 2.
 *       Input:
 *          28
 *      Output:
 *          6
 *
 *          28 = 10 + 10 + 5 + 1 + 1 + 1.
 */

/**
 * @author Swarn Singh.
 */
public class MoneyChange {

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int money = fastScanner.nextInt();
        int[] availableCoins = new int[]{10, 5, 1};
        if (money > 0 && money <= 1000) {
            System.out.println(getChange(availableCoins, money));
        }
    }

    private static int getChange(int[] availableCoins, int money) {
        int changeCount = 0;

        while (money > 0) {
            for (int i : availableCoins) {
                int temp = money - i;
                if (temp >= 0) {
                    System.out.print(i + " ");
                    money = money - i;
                    changeCount++;
                    break;
                }
            }
        }
        System.out.println("\n");
        return changeCount;
    }
}
