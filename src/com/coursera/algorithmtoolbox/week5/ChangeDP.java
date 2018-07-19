package com.coursera.algorithmtoolbox.week5;

import com.coursera.util.FastScanner;

import java.util.Arrays;

/**
 * Problem Description
 * Input Format. Integer money.
 * Output Format. The minimum number of coins with denominations 1, 3, 4 that changes money. Constraints. 1 ≤ money ≤ 10^3.
 * Sample 1.
 * Input:
 * 2
 * Output:
 * 2
 * 2 = 1 + 1.
 * <p>
 * Sample 2.
 * Input:
 * 34
 * Output:
 * 9
 * 34 = 3 + 3 + 4 + 4 + 4 + 4 + 4 + 4 + 4.
 */

/**
 * @author Swarn Singh.
 */
public class ChangeDP {

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);
        int money = fastScanner.nextInt();
        int[] availableCoins = new int[]{4, 3, 1};
        if (money > 0 && money <= 1000) {
            System.out.println(getMinimumChange(availableCoins, money, money));
        }
    }

    public static int getMinimumChange(int[] availableCoins, int money, int minChangeCount) {
        int changeCount;

        int coinsCount = availableCoins.length;
        int tempMoney;

        for (int i = 0; i < coinsCount; i++) {
            tempMoney = money;
            changeCount = 0;
            for (int j = i; j < coinsCount; j++) {
                int currentCoin = availableCoins[j];
                while (tempMoney > 0) {
                    if (tempMoney % currentCoin == 0) {
                        changeCount += tempMoney / currentCoin;
                        if (minChangeCount > changeCount) {
                            minChangeCount = changeCount;
                        }
                        break;
                    }
                    int deductedMoney = tempMoney - currentCoin;

                    if (deductedMoney > 0) {
                        if ((deductedMoney - currentCoin) < currentCoin) {
                            changeCount++;
                            if (minChangeCount > changeCount) {
                                changeCount += getMinimumChange(Arrays.copyOfRange(availableCoins, j, coinsCount), deductedMoney, minChangeCount);
                                tempMoney = 0;
                                if (minChangeCount > changeCount) {
                                    minChangeCount = changeCount;
                                }
                            }
                            break;
                        } else {
                            tempMoney -= currentCoin;
                            changeCount++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println("\n");
        return minChangeCount;
    }
}

