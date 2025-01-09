package com.swarn.datastructure.arrays;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Move the left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Move the right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move pointers inward
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(s));
    }
}
