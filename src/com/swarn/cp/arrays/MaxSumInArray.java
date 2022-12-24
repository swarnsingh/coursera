package com.swarn.cp.arrays;

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
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
}
