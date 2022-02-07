package com.coursera.algorithmtoolbox.week3;

/**
 * Problem Introduction
 * You have 𝑛 ads to place on a popular Internet page. For each ad, you know how much is the advertiser willing to pay for one click on this ad. You have set up 𝑛 slots on your page and estimated the expected number of clicks per day for each slot. Now, your goal is to distribute the ads among the slots to maximize the total revenue.
 * Problem Description
 * Task. Given two sequences 𝑎1,𝑎2,...,𝑎𝑛 (𝑎𝑖 is the profit per click of the 𝑖-th ad) and 𝑏1,𝑏2,...,𝑏𝑛 (𝑏𝑖 is the average number of clicks per day of the 𝑖-th slot), we need to partition them into 𝑛 pairs (𝑎𝑖,𝑏𝑗) such that the sum of their products is maximized.
 * Input Format. The first line contains an integer 𝑛, the second one contains a sequence of integers 𝑎1,𝑎2,...,𝑎𝑛, the third one contains a sequence of integers 𝑏1,𝑏2,...,𝑏𝑛.
 * Constraints. 1≤𝑛≤10^3;−10^5 ≤𝑎𝑖,𝑏𝑖 ≤10^5 for all 1≤𝑖≤𝑛.
 *
 * Output Format. Output the maximum value of ∑︀ 𝑎𝑖𝑐𝑖, where 𝑐1, 𝑐2, . . . , 𝑐𝑛 is a permutation of
 * 𝑏1,𝑏2,...,𝑏𝑛. Sample 1.
 * Input:
 * Output:
 * 897
 * 897 = 23 · 39. Sample 2.
 * Input:
 * Output:
 * 23
 * 23 = 3 · 4 + 1 · 1 + (−5) · (−2).
 */

import java.util.*;

/**
 * @author Swarn Singh.
 */

public class DotProduct {
    private static long maxDotProduct(List a, List b) {
        Collections.sort(a);
        Collections.sort(b);
        long result = 0;
        for (int i = 0; i < a.size(); i++) {
            result += (long) (Integer) a.get(i) * (Integer) b.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(i,scanner.nextInt());
        }
        List<Integer> b = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            b.add(i,scanner.nextInt());
        }
        System.out.println(maxDotProduct(a, b));
    }
}