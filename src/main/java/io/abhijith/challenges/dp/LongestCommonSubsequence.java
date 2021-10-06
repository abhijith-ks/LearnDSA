package io.abhijith.challenges.dp;

/**
 * Given two string X and Y. 
 * The task is to find the length of longest subsequence of string X which is substring in sequence Y.
 * Subsequence not necessarily to be continues
 * 
 * Dynamic Programming
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;

public class LongestCommonSubsequence {
	Integer mem[][] = new Integer[5][6];

	public void findSolution() {
		
		for(int i=0;i<5;i++)
			Arrays.fill(mem[i], -1);
		
		System.out.println(lcs("BATD","ABACD",0,0));
		System.out.println(dpSolution("BATD","ABACD"));
	}
	
	public int lcs(String p, String q, int n, int m) {
		
		int result;
		if(mem[n][m] != -1)
			return mem[n][m];
		
		if(n == p.length() || m == q.length())
			result = 0;
		else if (p.charAt(n) == q.charAt(m)) {
			result = 1 + lcs(p,q,n+1,m+1);
		}
		else {
			int temp1 = lcs(p,q,n,m+1);
			int temp2 = lcs(p,q,n+1,m);
			result = Integer.max(temp1, temp2);
		}
		mem[n][m] = result;
		
		return result;
	}
	
	
	
	public int dpSolution(String s1, String s2) {
		if(s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] a = new int[l1 + 1][l2 + 1];

        for(int i = 0; i <= l1; i++) {
            a[i][0] = 0;
        }

        for(int i = 0; i <= l2; i++) {
            a[0][i] = 0;
        }

        for(int i = 0; i < l1; i++) {
            for(int j = 0; j < l2; j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    a[i + 1][j + 1] = 1 + a[i][j];
                } else {
                    a[i + 1][j + 1] = Math.max(a[i + 1][j], a[i][j + 1]);
                }
            }
        }

        return a[l1][l2];
	}
	
}
