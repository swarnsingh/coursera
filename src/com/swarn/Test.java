package com.swarn;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Swarn Singh.
 */
public class Test {
    public static void main(String[] args) {
        /*StringBuilder sb = new StringBuilder("You have %1$s %2$s left");
        System.out.println(sb.lastIndexOf("%1$s"));
        String str = "You have %1$s %2$s left";
        String[] arr = str.split("%1$s");
        for (String s : arr) {
            System.out.println(s);
        }*/
        //System.out.println("Hello World");
        //createScanDefaultFileName("Scan_");
        /*int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);*/
        /*int[] inp = new int[]{2, 1};
        moveZeroes(inp);
        for (int i : inp) {
            System.out.print(i + " ");
        }*/
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        for (int i : set) {
            System.out.println(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && count > 0) {
                nums[left] = nums[i];
                nums[i] = 0;
                left++;
            } else if (nums[i] == 0) {
                count++;
            }
        }
    }

    public static String createScanDefaultFileName(String s) {
        StringBuilder name = new StringBuilder();
        Date now = new Date();

        System.out.println(System.getenv());

        System.out.println(System.getenv());

        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("MMdd_HHmmss");
        String date = dateFormat.format(now);

        if (s.isEmpty())
            name.append("RP_");
        else
            name.append(s).append("_");

        name.append(date);

        return name.toString();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        for (int t = 0; t < nums1.length; t++) {
            temp[t] = nums1[t];
        }

        int i = 0;
        int j = 0;
        for (int k = 0; k < temp.length; k++) {
            if (i >= temp.length || j >= nums2.length)
                break;
            if (temp[i] > nums2[j]) {
                nums1[k] = nums2[j];
                j++;
            } else {
                if (nums2[j] > temp[i] && i >= m) {
                    nums1[k] = nums2[j];
                    j++;
                } else {
                    nums1[k] = temp[i];
                }
                i++;
            }
        }
        for (int item : nums1) {
            System.out.print(item + " ");
        }
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();
        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            StringBuilder sb = new StringBuilder();
            boolean isPlusAvailable = false;
            boolean flag = false;
            for (int j = 0; j < email.length(); j++) {
                char c = email.charAt(j);

                if (c == '+') {
                    isPlusAvailable = true;
                    continue;
                } else if (c == '.' && !flag) {
                    continue;
                } else if (c == '@') {
                    flag = true;
                    sb.append(c);
                } else if (!isPlusAvailable) {
                    sb.append(c);
                } else if (flag) {
                    sb.append(c);
                }
            }

            set.add(sb.toString());
        }
        return set.size();
    }

    static int print2largest(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder("123");
        int item = Integer.parseInt(String.valueOf(sb.charAt(0)));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != max && arr[i] > secondMax) {
                secondMax = arr[i];
                flag = true;
            }
        }
        if (flag) {
            return secondMax;
        } else {
            return -1;
        }
    }
}
