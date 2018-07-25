package com.coursera.algorithmtoolbox.week6;

import com.coursera.util.FastScanner;

import java.util.Arrays;
import java.util.Collections;

/**
 * Problem Introduction
 * You are given a set of bars of gold and your goal is to take as much gold as possible into your bag.
 * There is just one copy of each bar and for each bar you can either take it or not (hence you cannot take a
 * fraction of a bar).
 * Problem Description
 * Task. Given 𝑛 gold bars, find the maximum weight of gold that fits into a bag of capacity 𝑊 .
 * Input Format. The first line of the input contains the capacity 𝑊 of a knapsack and the number 𝑛 of bars
 * of gold. The next line contains 𝑛 integers 𝑤0 , 𝑤1 , . . . , 𝑤𝑛−1 defining the weights of the bars of gold.
 * Constraints. 1 ≤ 𝑊 ≤ 10^4; 1 ≤ 𝑛 ≤ 300; 0 ≤ 𝑤0,...,𝑤𝑛−1 ≤ 10^5.
 * Output Format. Output the maximum weight of gold that fits into a knapsack of capacity 𝑊 .
 * Sample 1.
 * Input:
 * 10 3
 * 1 4 8
 * Output:
 * 9
 * Here, the sum of the weights of the first and the last bar is equal to 9.
 */

/**
 * @author Swarn Singh.
 */
public class Knapsack {
    static int optimalWeight(int W, Integer[] w) {
        //write you code here
        Arrays.sort(w, Collections.reverseOrder());
        int result = 0;
        for (int i = 0; i < w.length; i++) {
            if (result + w[i] <= W) {
                result += w[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        Integer[] w = new Integer[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}