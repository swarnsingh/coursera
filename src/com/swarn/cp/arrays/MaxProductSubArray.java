package com.swarn.cp.arrays;

/**
 * @author Swarn Singh.
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxProduct = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int result = 1;
            for (int j = i; j < nums.length; j++) {
                result *= nums[j];
                maxProduct = Math.max(result, maxProduct);
            }
        }
        return maxProduct;
    }
}
