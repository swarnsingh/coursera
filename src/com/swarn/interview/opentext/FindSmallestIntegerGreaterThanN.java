package com.swarn.interview.opentext;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * If N = 14 then their each digit sum is 1 + 4 = 5
 * We need to find a minimum number whose digits sum is double or greater than N's digit's sum
 * So, 19 is the ans, 1 + 9 = 10
 *
 * @author Swarn Singh.
 */
public class FindSmallestIntegerGreaterThanN {

    public static void main(String[] args) {
        System.out.println(solution(99));
        System.out.println(minimumNumber(14));
    }

    public static int minimumNumber(int n) {
        int sum = getSum(n);
        int num = 1;
        for (; ; ) {
            if (getSum(num) > sum) {
                break;
            }
            num++;
        }

        return num;
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> list = new ArrayList();
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0 ; i < strings.length; i++) {
            List l = map.get(strings[i].length());
            if (l == null) {
                l = new ArrayList();
            }
            l.add(strings[i]);
            map.put(strings[i].length(), l);
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
           List<String> values = new ArrayList<>();
            for (String str: entry.getValue()) {
                values.add(str);
            }
            list.add(values);
        }
        return list;
    }

    static int getSum(int n) {

        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static int solution(int N) {
        int maxSum = 0;

        String valueN = String.valueOf(N);
        int valueNSum = 0;
        for (int i = 0; i < valueN.length(); i++) {
            valueNSum += Integer.parseInt(valueN.charAt(i) + "");
        }
        for (int i = N + 1; i < Integer.MAX_VALUE; i++) {
            String maxValue = String.valueOf(i);
            int maxValueSum = 0;
            for (int j = 0; j < maxValue.length(); j++) {
                maxValueSum += Integer.parseInt(maxValue.charAt(j) + "");
            }
            if (maxValueSum >= valueNSum * 2) {
                maxSum = i;
                break;
            }
        }
        return maxSum;
    }
}
