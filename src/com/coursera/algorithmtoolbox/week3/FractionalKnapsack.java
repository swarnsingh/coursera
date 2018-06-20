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

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Swarn Singh.
 */
public class FractionalKnapsack {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int number = scanner.nextInt();
        int weight = scanner.nextInt();

        Item[] items = new Item[number];

        while (number > 0) {
            number--;
            Item item = new Item();
            item.value = scanner.nextInt();
            item.weight = scanner.nextInt();
            item.profit = item.value / item.weight;
            item.isLooted = false;
            items[number] = item;
        }

        System.out.println("Maximum Profit : " + getMaxLootProfit(weight, items));
    }

    /**
     *
     * @param weight, here maximum knapsack weight
     * @param items, no. of items available
     * @return maximum profit
     *
     * Now each iteration is O(1)
     *
     * Knapsack after sorting is O(n)
     *
     * Sort + Knapsack is O(n log n)
     *
     */
    private static double getMaxLootProfit(int weight, Item[] items) {
        double totalProfit = 0;
        Arrays.sort(items, Comparator.comparingDouble(Item::getProfit));
        int n = items.length - 1;

        while (weight > 0 && n >= 0) {
            Item item = items[n];
            n--;
            if (item.weight <= weight) {
                weight -= item.weight;
                totalProfit += item.value;
            } else {
                if (item.weight > weight) {
                    totalProfit += item.value / (item.weight / weight);
                    weight = 0;
                }
            }
            continue;
        }
        return totalProfit;
    }

    /**
     *
     * @param weight, here maximum knapsack weight
     * @param items, no. of items available
     * @return maximum profit
     *
     * It takes O(n^2) time
     */
    private static double getMaxProfit(int weight, Item[] items) {
        double totalProfit = 0;
        int n = items.length - 1;

        while (weight > 0) {
            double maxProfit = 0;
            int pos = 0;
            Item item = null;

            for (int i = 0; i < items.length; i++) {
                if (!items[i].isLooted && items[i].profit >= maxProfit) {
                    item = items[i];
                    maxProfit = item.profit;
                    pos = i;
                }
            }

            if (item != null) {
                item.isLooted = true;
                items[pos] = item;
                if (item.weight <= weight) {
                    weight -= item.weight;
                    totalProfit += item.value;
                } else {
                    if (item.weight > weight) {
                        totalProfit += item.value / (item.weight / weight);
                        weight = 0;
                    }
                }
            }
            continue;
        }

        return totalProfit;
    }

    static class Item {
        int value;
        int weight;
        boolean isLooted;
        double profit;

        public double getProfit() {
            return profit;
        }
    }
}
