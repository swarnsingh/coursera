package com.coursera.algorithmtoolbox.week3;

/**
 * Maximum Value of the Loot
 * Problem Introduction
 * A thief finds much more loot than his bag can fit. Help him to find the most valuable combination of items
 * assuming that any fraction of a loot item can be put into his bag.
 * <p>
 * Problem Description
 * Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
 * <p>
 * Input Format. The first line of the input contains the number 𝑛 of items and the capacity 𝑊 of a knapsack.
 * The next 𝑛 lines define the values and weights of the items. The 𝑖-th line contains integers 𝑣𝑖 and 𝑤𝑖—the
 * value and the weight of 𝑖-th item, respectively.
 * <p>
 * Constraints. 1≤𝑛≤10^3,0≤𝑊 ≤2·10^6;0≤𝑣𝑖 ≤2·10^6,0<𝑤𝑖 ≤2·10^6 for all 1≤𝑖≤𝑛. All the numbers are integers.
 * <p>
 * Output Format. Output the maximal value of fractions of items that fit into the knapsack. The absolute value
 * of the difference between the answer of your program and the optimal value should be at most 10−3. To ensure
 * this, output your answer with at least four digits after the decimal point (otherwise your answer, while
 * being computed correctly, can turn out to be wrong because of rounding issues).
 * <p>
 * Sample 1.
 * Input:
 * 3 50
 * 60 20
 * 100 50
 * 120 30
 * <p>
 * Output:
 * 180.0000
 * To achieve the value 180, we take the first item and the third item into the bag. Sample 2.
 * <p>
 * Input:
 * 1 10
 * 500 30
 * Output:
 * 166.6667
 * <p>
 * Here, we just take one third of the only available item.
 */

import com.coursera.util.FastScanner;

/**
 * @author Swarn Singh.
 */
public class FractionalKnapsack {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int number = scanner.nextInt();
        int weight = scanner.nextInt();

    }
}
