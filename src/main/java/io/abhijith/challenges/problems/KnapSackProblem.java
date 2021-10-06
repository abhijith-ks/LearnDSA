package io.abhijith.challenges.problems;

/**
 * 0-1 Knapsack problem
 * Given weights and values of n items, 
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * In other words, given two integer arrays v[0..n-1] and w[0..n-1] which represent values and weights associated with n items respectively. 
 * Also given an integer W which represents knapsack capacity, 
 * find out the maximum value subset of v[] such that sum of the weights of this subset is smaller than or equal to W. 
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * 
 * Dynamic Programming
 * 
 * @author abhijith-ks
 *
 */

public class KnapSackProblem {

	int w[] = new int[] {Integer.MAX_VALUE,1,2,4,2,1};
	int v[] = new int[] {Integer.MAX_VALUE,5,3,5,3,2};
	int mem[][] = new int[6][11];
	
	public void findSolution() {
		
		for(int i=0;i<6;i++)
			for(int j=0;j<11;j++)
				mem[i][j] = -1;
		
		System.out.println(knapSack(w.length-1,10));
		
	}
	
	public int knapSack(int n, int c) {
		int result;
		
		if(mem[n][c] != -1) {
			return mem[n][c];
		}
		
		if(n==0 || c==0)
			result = 0;
		else if(w[n] > c)
			result = knapSack(n-1, c);
		else {
			int temp1 = knapSack(n-1, c);
			int temp2 = v[n] + knapSack(n-1, c-w[n]);
			result = Integer.max(temp1, temp2);  
		}
		mem[n][c] = result;
		return result;
	}

}
 
