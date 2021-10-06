package io.abhijith.challenges.dp;

/**
 * Write a program to perform regex matching with * an .
 *
 * References : http://leetcode.com/2011/09/regular-expression-matching.html
 * https://www.youtube.com/watch?v=l3hda49XcDE&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=11
 */

public class RegularExpressionPatternMatching {

    public void findSolution() {

        String text = "xaabyc";
        String pattern = "xa*b.c";

        boolean[][] dpMatrix = new boolean[text.length() + 1][pattern.length() + 1];
        dpMatrix[0][0] = true;

        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt( j - 1) == '.') {
                    dpMatrix[i][j] = dpMatrix[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*'){
                    if(j - 2 >= 0) {
                        dpMatrix[i][j] = dpMatrix[i][j - 2];
                    }
                    if(pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)) {
                        dpMatrix[i][j] = dpMatrix[i][j] | dpMatrix[i - 1][j];
                    }
                } else {
                    dpMatrix[i][j] = false;
                }
            }
        }

        System.out.println(dpMatrix[text.length()][pattern.length()]);

    }

}
