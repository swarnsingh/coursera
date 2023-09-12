package com.swarn.cp.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Swarn Singh.
 */
public class MaxSumInArray {
    static int maxSum(int[] arr, int n, int k) {
        // n must be greater
        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];

        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            int a = arr[i];
            int b = arr[i - k];
            int sum = a - b;
            window_sum += sum;
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int[][] arr1 = {{0, 30}, {5, 10}, {15, 20}};
        //int[][] arr1 = {{7, 10}, {2, 4}};
        Arrays.sort(arr1, Comparator.comparingInt(a -> a[0]));
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));

        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit : " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
        /*int maxProfit = 0;
        int pricesLength = prices.length - 1;

        for (int i = 0; i < pricesLength; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int buyingPrice = prices[i];
                int sellingPrice = prices[j];

                if (sellingPrice > buyingPrice) {
                    int profit = sellingPrice - buyingPrice;
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
        }

        return maxProfit;*/

    }
}
