package io.abhijith;

import java.util.Arrays;

public class TestDriver {

    public void findSolution() {

        int m = 3, n = 4;

        int dp[][] = new int[m][n];

        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        System.out.println(dp[m - 1][n - 1]);

    }



    public static void main(String[] args) {
        TestDriver driver = new TestDriver();
        driver.findSolution();
    }

}
