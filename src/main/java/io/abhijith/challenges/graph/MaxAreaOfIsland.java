package io.abhijith.challenges.graph;

/**
 * Given a non-empty 2D array of 0's and 1's.
 * An island is a group of 1's connected 4-directionally.
 * 
 * Find the maximum area of an island in the given 2D array.
 * 
 * @author abhijith-ks
 */

public class MaxAreaOfIsland {
	
	int[][] area = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
	                           {0,0,0,0,0,0,0,1,1,1,0,0,0},
	                           {0,1,1,0,1,0,0,0,0,0,0,0,0},
	                           {0,1,0,0,1,1,0,0,1,0,1,0,0},
	                           {0,1,0,0,1,1,0,0,1,1,1,0,0},
	                           {0,0,0,0,0,0,0,0,0,0,1,0,0},
	                           {0,0,0,0,0,0,0,1,1,1,0,0,0},
	                           {0,0,0,0,0,0,0,1,1,0,0,0,0}};
	
	public void findSolution() {
		
		int max = 0;
		for(int i = 0; i < area.length; i++) {
			for(int j = 0; j < area[i].length; j++) {
				if(area[i][j] == 1) {
					max = Math.max(max, graphTraversal(i, j));
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	public int graphTraversal(int i, int j) {
		if(i < 0 || j < 0 || i >= area.length || j >= area[0].length || area[i][j] == 0 ) {
			return 0;
		}
		area[i][j] = 0;

		int count = 1;
		count += graphTraversal(i + 1, j);
		count += graphTraversal(i - 1, j);
		count += graphTraversal(i, j + 1);
		count += graphTraversal(i, j - 1);
		return count;
	}

}
