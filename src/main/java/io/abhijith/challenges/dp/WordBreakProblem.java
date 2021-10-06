package io.abhijith.challenges.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string and a dictionary,
 * return true if string can be split into multiple words such that each word is in dictionary.
 * If not return false
 */

public class WordBreakProblem {

    Set<String> dictionary = new HashSet<>();

    public void findSolution() {

        dictionary.add("i");
        dictionary.add("am");
        dictionary.add("ace");
        dictionary.add("a");

        String s = "iamace";
        int m = s.length();

        boolean[][] dp = new boolean[m][m];

        for(int i = 0; i < m; i++) {
            if(dictionary.contains("" + s.charAt(i))) {
                dp[i][i] = true;
            }
        }

        for(int l = 2; l <= m; l++) {
            for(int i = 0; i < m - l + 1; i++) {
                int j = i + l - 1;
                if(dictionary.contains(s.substring(i, j + 1))) {
                    dp[i][j] = true;
                } else {
                    for(int k = i + 1; k <= j; k++) {
                        if(dp[i][k - 1] && dp[k][j]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(dp[0][m - 1]);

        System.out.println();
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < m; j++) {
                System.out.print("\t" + dp[i][j]);
        	}
            System.out.println();
        }

    }

}
