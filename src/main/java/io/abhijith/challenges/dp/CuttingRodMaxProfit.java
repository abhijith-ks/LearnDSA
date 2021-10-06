package io.abhijith.challenges.dp;

/**
 * Given a rod of length n inches and an array of prices
 * that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 */

public class CuttingRodMaxProfit {

    public void findSolution() {

        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        int val[] = new int[n + 1];
        val[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,
                        price[j] + val[i - j - 1]);
            val[i] = max_val;
        }

        System.out.println(val[n]);
    }

}
