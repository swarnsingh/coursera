package com.swarn.cp.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * @author Swarn Singh.
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            boolean flag = set.add(nums[i]);
            if (!flag) {
                duplicate = nums[i];
            }
        }
        return duplicate;
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        String str = "Hello World";
        StringBuilder sb = new StringBuilder();
    }
}
