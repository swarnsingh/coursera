package com.cp.arrays;

/**
 * Example 1:
 * <p>
 * Input: nums = [1,2,0]
 * min 2
 * max 2
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: nums = [7,8,9,11,12,2,1]
 * Output: 1
 *
 * @author Swarn Singh.
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        boolean[] present = new boolean[nums.length];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                present[num - 1] = true;
            }
        }
        for (int i = 0; i < present.length; i++) {
            if (!present[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 9, 9, 9, 2, 3};
        System.out.println(firstMissingPositive(nums));
    }
}
