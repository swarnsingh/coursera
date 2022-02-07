package com.cp.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * Given a list of non-negative integers, arrange them such that they form the largest number.
 * <p>
 * For example:
 * <p>
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * https://www.interviewbit.com/problems/largest-number/
 *
 * @author Swarn Singh.
 */
public class LargestNumber {

    public static String largestNumber(final List<Integer> A) {
        StringBuilder largestNumber = new StringBuilder();
        List<String> arr = new ArrayList<>(A.size());
        A.forEach((item) -> {
            arr.add(String.valueOf(item));
        });

        arr.sort((X, Y) -> {
            String XY = X + Y;
            String YX = Y + X;

            return XY.compareTo(YX) > 0 ? -1 : 1;
        });
        for (String s : arr) {
            largestNumber.append(s);
        }
        BigInteger bigInteger = new BigInteger(largestNumber.toString());
        return bigInteger.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(5);
        list.add(3);
        list.add(30);
        list.add(34);
        list.add(5);
        list.add(9);
        System.out.println(largestNumber(list));
    }
}
