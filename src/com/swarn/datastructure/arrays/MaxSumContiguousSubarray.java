package com.swarn.datastructure.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Swarn Singh.
 */
public class MaxSumContiguousSubarray {

    public static int maxSubArray(final List<Integer> A) {

        int maxSum = A.get(0);
        int preMaxSum = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            maxSum = Math.max(A.get(i), A.get(i) + maxSum);
            if (maxSum > preMaxSum) {
                preMaxSum = maxSum;
                continue;
            }
        }
        return Math.max(maxSum, preMaxSum);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-163);
        list.add(-20);
        list.add(-3);
        list.add(4);
        list.add(-1);
        list.add(2);
        list.add(1);
        list.add(-5);
        list.add(4);

        System.out.println("Max SubArray sum: " + maxSubArray(list));
    }
}
