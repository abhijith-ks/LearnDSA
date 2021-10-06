package io.abhijith.challenges.problems;

/**
 * Given n non-negative integers a1,a2,..,an, where each represents a point at coordinate(j,a).
 * n vertical lines are drawn such that the two end-points of line i is at (j,a) and (j,0).
 * Find two lines which together with x-axis forms a container, such that the container contains the most water.
 * 
 * You may not slant the container and n is at least 2.
 * O(n)
 * 
 * @author abhijith-ks
 */

public class ContainerWithMostWater {
	
	public void findSolution(int[] heights) {
		
		int i = 0;
		int j = heights.length - 1;
		int max = Integer.MIN_VALUE;
		
		while(i < j) {
			int min = Math.min(heights[i], heights[j]);
			max = Math.max(max, min * (j - i));
			if(heights[i] < heights[j])
				i++;
			else
				j--;
		}
		
		System.out.println(max);
	}

}
