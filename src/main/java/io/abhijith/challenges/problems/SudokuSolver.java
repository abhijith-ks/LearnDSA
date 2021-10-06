package io.abhijith.challenges.problems;

/**
 * Develop a Sudoku Solver
 * 
 * @author abhijith-ks
 */

public class SudokuSolver {
	
	private int counter = 0;
	private final int EMPTY = Integer.MIN_VALUE;
	private int[][] board = new int[][]{
		{5, 3, EMPTY, EMPTY, 7, EMPTY, EMPTY, EMPTY, EMPTY},
		{6, EMPTY, EMPTY, 1, 9, 5, EMPTY, EMPTY, EMPTY},
		{EMPTY, 9, 8, EMPTY, EMPTY, EMPTY, EMPTY, 6, EMPTY},
		{8, EMPTY, EMPTY, EMPTY, 6, EMPTY, EMPTY, EMPTY, 3},
		{4, EMPTY, EMPTY, 8, EMPTY, 3, EMPTY, EMPTY, 1},
		{7, EMPTY, EMPTY, EMPTY, 2, EMPTY, EMPTY, EMPTY, 6},
		{EMPTY, 6, EMPTY, EMPTY, EMPTY, EMPTY, 2, 8, EMPTY},
		{EMPTY, EMPTY, EMPTY, 4, 1, 9, EMPTY, EMPTY, 5},
		{EMPTY, EMPTY, EMPTY, EMPTY, 8, EMPTY, EMPTY, 7, 9}
		};
	
	public void findSolution() {
		solveSudoku(0, 0, board);

		for(int i = 0; i < board.length; i++) {
			System.out.println();
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
		}
	}
	
	
//	Driver Function for Sudoku Solver
	public boolean solveSudoku(int row, int col, int[][] board) {

		if(col == board[row].length) {
			col = 0;
			row = row + 1;
//			Exit condition. ie, done processing the entire board
			if(row == board.length) {
				return true;
			}
		}
		
		if(board[row][col] != EMPTY) {
			return solveSudoku(row, col + 1, board);
		}
		
//		Try to place 1-board length in the cell
		for(int value = 1; value <= board.length; value++) {
			if(canPlaceValue(row, col, board, value)) {
				board[row][col] = value;
				if(solveSudoku(row, col + 1, board)) {
					return true;
				}
			}
		}
		
//		If placement breaks any of the condition, remove the placement
		board[row][col] = EMPTY;
		return false;
	}
	
	
	public boolean canPlaceValue(int row, int col, int[][] board, int value) {
		
//		Validation check column level
		for(int[] element: board) {
			if(value == element[col]) {
				return false;
			}
		}
		
//		Validation check row level
		for(int i = 0; i < board[row].length; i++) {
			if(value == board[row][i]) {
				return false;
			}
		}
		
//		Validation check sub-box level
		int regionSize = (int) Math.sqrt(board.length);
		int iVal = row / regionSize;
		int jVal = col / regionSize;
//		Top left corner of sub-box
		int topLeftOfSubboxRow = iVal * regionSize;
		int topLeftOfSubboxCol = jVal * regionSize;
		
		for(int i = 0; i < regionSize; i++) {
			for(int j = 0; j < regionSize; j++) {
				if(value == board[i + topLeftOfSubboxRow][j + topLeftOfSubboxCol]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
