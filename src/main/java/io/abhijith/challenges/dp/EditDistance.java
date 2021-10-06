package io.abhijith.challenges.dp;

/**
 * Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another
 *
 * Dynamic Programming
 *
 * Time complexity is O(m*n)
 * Space complexity is O(m*n)
 */

public class EditDistance {

    public void findSolution() {

        String s1 = "azced";
        String s2 = "abcdef";

        int[][] dpMatrix = new int[s1.length() + 1][s2.length()  + 1];

        for(int i = 0; i <= s1.length(); i++) {
            dpMatrix[i][0] = i;
        }
        for(int i = 0; i <= s2.length(); i++) {
            dpMatrix[0][i] = i;
        }

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dpMatrix[i][j] = dpMatrix[i - 1][j - 1];
                } else {
                    dpMatrix[i][j] = 1 + Math.min(dpMatrix[i - 1][ j - 1], Math.min(dpMatrix[i  - 1][j], dpMatrix[i][j - 1]));
                }
            }
        }

        System.out.println("DP Matrix -> ");

        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                System.out.print("\t" + dpMatrix[i][j]);
            }
            System.out.println();
        }

        System.out.println("Number of edits required: " + dpMatrix[s1.length()][s2.length()]);

    }

}
