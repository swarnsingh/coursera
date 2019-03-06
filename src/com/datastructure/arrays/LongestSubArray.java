package com.datastructure.arrays;

/**
 * @author Swarn Singh.
 */
public class LongestSubArray {

    public static String getLongestSubArrayString(String[] arr) {
        StringBuilder sb = new StringBuilder();

        if (arr.length > 1) {
            for (int i = 0; i < arr[i].length(); i++) {
                char str1 = arr[0].charAt(i);
                sb.append(str1);
                for (int j = 1; j < arr.length; j++) {
                    if (arr[j].length() > i) {
                        char str2 = arr[j].charAt(i);
                        if (str1 != str2) {
                            sb.deleteCharAt(i);
                            return sb.toString();
                        }
                    } else {
                        sb.deleteCharAt(i);
                        return sb.toString();
                    }
                }
            }
        } else {
             sb.append(arr[0]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String [] arr = new String[]{"geeksforgeeks", "geeks", "geeko", "geek", "geekm"};

        System.out.println("Longest sub array string is : "+getLongestSubArrayString(arr));
    }
}
