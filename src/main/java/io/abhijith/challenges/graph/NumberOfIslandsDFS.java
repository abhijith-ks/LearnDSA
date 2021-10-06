package io.abhijith.challenges.graph;

/**
 * Given a 2-d map of '1's(land) and '0's(water), count the number of islands
 * An island is surrounded by water and formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are also surrounded by water.
 * 
 * Example: 3 islands are there in the following grid
 * {'1','1','0','0','0'}
 * {'1','1','0','0','0'}
 * {'0','0','1','0','0'}
 * {'0','0','0','1','1'}
 * 
 * This program is an example for Graph traversal using DFS (you can use BFS as well)
 * 
 * @author abhijith-ks
 *
 */

public class NumberOfIslandsDFS {
	
	public void findSolution(char grid[][]) {
		
		int counts = 0;
		
		if(grid == null || grid.length == 0) {
			System.out.println("Number of Islands : " + 0);
			return;
		}
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j < grid[i].length; j++) {
				if(grid[i][j] == '1') {
					counts += dfs(grid, i, j); 
				}
			}
		}
		
		System.out.println("Number of Islands : " + counts);
		
	}
	
	public int dfs(char[][] grid, int i, int j) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
			return 0;
		
		grid[i][j] = '0';
		
		dfs(grid, i-1, j);
		dfs(grid, i+1, j);
		dfs(grid, i, j-1);
		dfs(grid, i, j+1);
		return 1;
	}

}
