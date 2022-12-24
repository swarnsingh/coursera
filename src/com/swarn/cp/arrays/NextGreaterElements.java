package com.swarn.cp.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 * <p>
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find
 * its next greater number. If it doesn't exist, return -1 for this number.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 * <p>
 * Input : [5,4,3,2,1]
 * Expected O/P - [-1,5,5,5,5]
 */
public class NextGreaterElements {

    static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }
}
