package io.abhijith.challenges.dp;

/**
 * Given some number of floors and some number of eggs,
 * what is the minimum number of attempts it will take to find out from which floor egg will break.
 *
 * https://www.youtube.com/watch?v=3hcaVyX00_4&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=14
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EggDropping.java
 */

public class EggDropping {

    public void findSolution() {

        int eggs = 2;
        int floors = 10;

        int[][] dpMatrix = new int[eggs + 1][floors + 1];

        for(int i = 0; i <= floors; i++) {
            dpMatrix[0][i] = i;
        }

        for(int i = 1; i <= eggs; i++) {
            for(int j = 1; j <= floors; j++) {
                dpMatrix[i][j] = Integer.MAX_VALUE;
                int c;
                for(int k = 1; k <= j; k++) {
                    c = 1 + Math.max(dpMatrix[i - 1][k - 1], dpMatrix[i][j - k]);
                    dpMatrix[i][j] = Math.min(dpMatrix[i][j], c);
                }
            }
        }

        System.out.println(dpMatrix[eggs][floors]);

    }

}
