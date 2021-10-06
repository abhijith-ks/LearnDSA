package io.abhijith.challenges.graph;

/**
 * Given a 2D board, count how many battleships are in it. 
 * The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * - You receive a valid board, made of only battleships or empty slots.
 * - Battleships can only be placed horizontally or vertically.
 * 	 In other words, they can only be made of the shape 1*N (1 row, N columns) or N*1 (N rows, 1 columns), where N can be of any size.
 * - At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * 
 * @author abhijith-ks
 *
 */

public class BattleshipGraphTraversal {
	
	char[][] a = new char[][]{
					{'X','.','.','X'},
					{'.','.','.','X'},
					{'.','.','.','X'}
					};
					
					
	public void betterSolution() {
		
		int countShips = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				if(a[i][j] == '.') {
					continue;
				}
				if(i > 0 && a[i-1][j] == 'X') {
					continue;
				}
				if(j > 0 && a[i][j-1] == 'X') {
					continue;
				}
				countShips++;
			}
		}
		System.out.println(countShips);
		
	}

	public void findSolution() {
		
		betterSolution();
		
		int countShips = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				if(a[i][j] == 'X') {
					countShips += 1;
					sink(i,j);
				}
			}
		}
		System.out.println(countShips);
	}
	
	public void sink(int i, int j) {

		if(i < 0 || i >= a.length || j < 0 || j >= a[i].length || a[i][j] != 'X') {
			return;
		}
		
		a[i][j] = '.';
		sink(i+1, j);
		sink(i-1, j);
		sink(i, j+1);
		sink(i, j-1);
		
	}
	
}
