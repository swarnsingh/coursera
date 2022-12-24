package com.swarn.datastructure.arrays;

import java.io.IOException;
import java.util.*;

/**
 * Problem Description
 * <p>
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the maximum value of j - i;
 * <p>
 * <p>
 * <p>
 * Example Input 1:
 * <p>
 * A = [3, 5, 4, 2]
 * <p>
 * <p>
 * Example Output 1:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation 1:
 * <p>
 * Maximum value occurs for pair (3, 4).
 */

/**
 * @author Swarn Singh.
 */
public class MaxDistance {

    public static int maximumGap(final List<Integer> a) {
        int n = a.size();
        ArrayDeque<Integer> A = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (A.isEmpty() || a.get(A.peekLast()) >= a.get(i)) {
                A.add(i);
            }
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!A.isEmpty() && a.get(i) >= a.get(A.peekLast())) {
                ans = Math.max(ans, i - A.pollLast());
            }
        }
        return ans;
    }

    public static void fizzBuzz(int n) {
        // Write your code here

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static boolean isParenthesisValid(String s) {
        if (s != null && !s.isEmpty()) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char d = stack.pop();
                    if (d == '(' && c != ')') {
                        return false;
                    } else if (d == '{' && c != '}') {
                        return false;
                    } else if (d == '[' && c != ']') {
                        return false;
                    }
                }
            }
            return stack.empty();
        }
        return false;
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        int minValue = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (A[i] == minValue) {
                    minValue++;
                }
            }
        }
        return minValue;
    }

    static class Interval {
        int buy, sell;
    }

    public static int maxProfit(int[] costs) {
        int maxProfit = 0;
        for (int i = 1; i < costs.length; i++)
            if (costs[i] > costs[i - 1])
                maxProfit += costs[i] - costs[i - 1];
        return maxProfit;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(2);

        //System.out.println(maximumGap(list));
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        fizzBuzz(n);

        bufferedReader.close();*/

        System.out.println("\"(()()[]{})\" is valid - " + isParenthesisValid("(()()[]{})"));
        int[] arr = new int[]{-1, -2, -3};
        System.out.println(solution(arr));
        int[] costs = new int[]{6, 5, 3, 7, 1, 4};
        System.out.println(maxProfit(costs));
    }
}
