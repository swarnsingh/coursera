package com.swarn.coursera.algorithmtoolbox.week5;

import com.swarn.coursera.util.FastScanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem Introduction
 * You are given a primitive calculator that can perform the following three operations with the current number
 * 𝑥: multiply 𝑥 by 2, multiply 𝑥 by 3, or add 1 to 𝑥. Your goal is given a positive integer 𝑛, find the minimum
 * number of operations needed to obtain the number 𝑛 starting from the number 1.
 * Problem Description
 * Task. Given an integer 𝑛, compute the minimum number of operations needed to obtain the number 𝑛 starting from
 * the number 1.
 * Input Format. The input consists of a single integer 1 ≤ 𝑛 ≤ 10^6.
 * Output Format. In the first line, output the minimum number 𝑘 of operations needed to get 𝑛 from 1. In the
 * second line output a sequence of intermediate numbers. That is, the second line should contain positive
 * integers 𝑎0,𝑎2,...,𝑎𝑘−1 such that 𝑎0 =1,𝑎𝑘−1 =𝑛and for all 0≤𝑖<𝑘−1,𝑎𝑖+1 is equal to either 𝑎𝑖 + 1, 2𝑎𝑖, or 3𝑎𝑖.
 * If there are many such sequences, output any one of them.
 * Sample 1.
 * Input:
 * 1
 * Output:
 * 0
 * 1
 * <p>
 * Sample 2.
 * Input:
 * 5
 * Output:
 * 3
 * 1 2 4 5
 * <p>
 * Here, we first multiply 1 by 2 two times and then add 1. Another possibility is to first multiply by 3 and then
 * add 1 two times. Hence “1 3 4 5” is also a valid output in this case.
 * Sample 3.
 * Input:
 * 96234
 * Output:
 * 14
 * 1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234
 * <p>
 * Again, another valid output in this case is “1 3 9 10 11 33 99 297 891 2673 8019 16038 16039 48117 96234”.
 */

/**
 * @author Swarn Singh.
 */
public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n - 1 != 0 && (n - 1) % 3 == 0) {
                sequence.add(n - 1);
                n = (n - 1) / 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
