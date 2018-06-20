package com.coursera.algorithmtoolbox.week1;

import com.coursera.util.FastScanner;

import java.math.BigInteger;

/**
 * @author Swarn Singh.
 */
public class MaxPairwiseProduct {

    static BigInteger getMaxPairwiseProduct(int[] numbers) {

        long largestNo = 0;
        long secondLargestNo = 0;

        for (int i : numbers) {
            if (i > largestNo) {
                if (i > secondLargestNo && largestNo > secondLargestNo)
                    secondLargestNo = largestNo;

                largestNo = i;
            } else if (i > secondLargestNo) {
                secondLargestNo = i;
            }
        }
        return BigInteger.valueOf(secondLargestNo * largestNo);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        if (n >= 2 && n <= 2 * Math.pow(10, 5)) {
            int[] numbers = new int[n];
            int no;
            for (int i = 0; i < n; i++) {
                no = scanner.nextInt();
                if (no > 0 && no <= 2 * Math.pow(10, 5))
                    numbers[i] = no;
            }
            System.out.println(getMaxPairwiseProduct(numbers));
        } else {
            System.out.println(0);
        }
    }
}
