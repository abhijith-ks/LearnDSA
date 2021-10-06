package io.abhijith.challenges.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m*n 2D grid initialized with these three possible values.
 * -1 -> A wall or an obstacle
 * 0 -> A gate
 * INF -> Infinity means an empty room.
 * 
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF
 * 
 * @author abhijith-ks
 *
 */

public class WallsAndGates {
	
	int INF = Integer.MAX_VALUE;

	final int[][] Directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	int[][] grid = new int[][] {{INF, -1, 0, INF},
								{INF, INF, INF, -1},
								{INF, -1, INF, -1},
								{0, -1, INF, INF}};
	
	public void findSolution() {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 0) {
					dfs(i,j,0);
				}
			}
		}
		
		for(int i = 0; i < grid.length; i++) {
			System.out.println();
			for(int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
		}
	}
	
	public void dfs(int i, int j, int sum) {
		
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] < sum) {
			return;
		}
		
		grid[i][j] = Math.min(grid[i][j], sum);
		
		sum += 1;
		dfs(i + 1, j, sum);
		dfs(i - 1, j, sum);
		dfs(i, j + 1, sum);
		dfs(i, j - 1, sum);
		
	}

	private void bfs() {

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					queue.add(new int[]{i, j});
				}
			}
		}

		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				int[] val = queue.poll();
				int i = val[0];
				int j = val[1];

				for(int[] direction: Directions) {
					int x = i + direction[0];
					int y = j + direction[1];

					if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] < level)
						continue;

					grid[x][y] = level;
					queue.add(new int[]{x, y});

				}
				size--;
			}
			level++;
		}

	}

}
