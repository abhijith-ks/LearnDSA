package io.abhijith.challenges.graph;

/**
 * Implement flood fill for the given image.
 * Graph DFS traversal algorithm
 * 
 * @author abhijith-ks
 */

public class FloodFill {
	
	int[][] image = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1},
						        {1, 1, 1, 1, 1, 1, 0, 0},
						        {1, 0, 0, 1, 1, 0, 1, 1},
						        {1, 2, 2, 2, 2, 0, 1, 0},
						        {1, 1, 1, 2, 2, 0, 1, 0},
						        {1, 1, 1, 2, 2, 2, 2, 0},
						        {1, 1, 1, 1, 1, 2, 1, 1},
						        {1, 1, 1, 1, 1, 2, 2, 1},
						        };
	
	public void findSolution(int x, int y, int newColor) {
		
		if(image[x][y] == newColor) {
			System.out.println("No need to change the color");
			return;
		}
		int currentColor = image[x][y];
		floodFill(x, y, newColor, currentColor);
		
		for(int i = 0; i < image.length; i++) {
			for(int j = 0; j < image[i].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void floodFill(int x, int y, int newColor, int currentColor) {
		if(x >= image.length || y >= image[0].length || x < 0 || y < 0 || image[x][y] != currentColor)
			return;
		
		image[x][y] = newColor;
		floodFill(x+1, y, newColor, currentColor);
		floodFill(x-1, y, newColor, currentColor);
		floodFill(x, y+1, newColor, currentColor);
		floodFill(x, y-1, newColor, currentColor);
	}

}
