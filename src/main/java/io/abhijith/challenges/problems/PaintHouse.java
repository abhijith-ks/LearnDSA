package io.abhijith.challenges.problems;

/**
 * There are a row of n houses, each houses can be painted with one of three colors red, green and blue.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses in such a way that no two adjacent houses have the same color
 * 
 * The cost of painting each house with a certain color is represented by a n*3 cost matrix.
 * Find the minimum cost to paint all houses
 * 
 * All costs are positive integer
 * 
 * Example: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * 
 * @author abhijith-ks
 *
 */

public class PaintHouse {
	
	public void findSolution(int a[][]) {
		
		if(a == null || a.length == 0) {
			System.out.println(0);
			return;
		}
		
		for(int i = 1; i < a.length; i++) {
			
			a[i][0] += Math.min(a[i-1][1], a[i-1][2]);
			a[i][1] += Math.min(a[i-1][0], a[i-1][2]);
			a[i][2] += Math.min(a[i-1][0], a[i-1][1]);
			
		}
		
		System.out.println(Math.min(Math.min(a[a.length-1][0], a[a.length-1][1]), a[a.length-1][2]));
		
	}

}
