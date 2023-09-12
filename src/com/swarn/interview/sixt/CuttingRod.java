package com.swarn.interview.sixt;

/**
 * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * <p>
 * For example,
 * if the length of the rod is 8 and the values of different pieces are given as the following, then the maximum
 * obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * <p>
 * <p>
 * <p>
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 *
 * @author Swarn Singh.
 */
public class CuttingRod {
    public static void main(String[] args) {
        int[] rods = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] prices = new int[]{1, 3, 3, 3, 4, 4, 6};
        System.out.println(maxProfit(rods, prices));
    }

    public static int maxProfit(int[] rods, int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < rods.length; i++) {
            int x = rods.length / (i + 1);
            int price;
            if (rods.length % (i + 1) == 0) {
                price = prices[i] * x;

            } else {
                price = (prices[i] * x) + prices[x - 1];
            }
            if (price > maxProfit) {
                maxProfit = price;
            }

            int y = rods.length - (i + 1);
            int temp = prices[y];
            if (y > 0) {
                temp = prices[y - 1];
            }
            int total = prices[i] + temp;
            if (total > maxProfit) {
                maxProfit = total;
            }
        }
        return maxProfit;
    }
}
