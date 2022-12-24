package com.swarn.cp.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4};
        int target = 6;
        int[] sum = twoSum(arr, target);
        for (int i : sum) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] x = new int[2];
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                x[0] = map.get(value);
                x[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return x;
    }
}
