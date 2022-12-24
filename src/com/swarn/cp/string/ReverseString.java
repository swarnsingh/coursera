package com.swarn.cp.string;

/**
 * String reverse without reversing the words
 * i/p : (My Name is Swarn)
 * o/p : (Swarn is Name My)
 *
 * @author Swarn Singh.
 */
public class ReverseString {
    public static void main(String[] args) {
        String str = "My Name is Swarn";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        StringBuilder reverse = new StringBuilder();
        String[] arr = str.split("\\s+");

        for (int i = arr.length - 1; i >= 0; i--) {
            reverse.append(arr[i]).append(" ");
        }
        return reverse.toString().trim();
    }
}
