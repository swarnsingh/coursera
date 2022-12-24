package com.swarn.cp.arrays;

/**
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * <p>
 * Input [0,0,1,1,1,0,0]
 * k = 0
 * Expected 3
 * <p>
 * Input
 * [0,0,0,1]
 * 4
 * Expected 4
 *
 * @author Swarn Singh.
 */
public class MaxConsecutiveOnes {

    public static int longestOnes(int[] nums, int k) {
        int count = 0;
        int kTemp = k;
        int m = k;

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            if (m == 0) {
                if (value == 1) {
                    if (i > 0 && nums[i - 1] == 0 && count > 0) {
                        break;
                    }
                    count++;
                }
            } else {
                if (kTemp > 0) {
                    if (value == 0) {
                        count = 0;
                        kTemp--;
                    } else {
                        if (kTemp < k) {
                            kTemp--;
                        }
                        count++;
                    }
                } else {
                    if (k > 0) {
                        if (value == 0) {
                            k--;
                        }
                        count++;
                    } else {
                        if (value == 0) {
                            break;
                        } else {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }
}
