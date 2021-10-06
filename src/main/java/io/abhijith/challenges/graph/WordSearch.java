package io.abhijith.challenges.graph;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * 
 * @author abhijith-ks
 *
 */

public class WordSearch {
	
	char[][] board = new char[][] {{'A','B','C','E'},
									{'S','F','C','S'},
									{'A','D','E','E'}};
	String word = "ABCCED";
	boolean foundFlag = false;
	
	public void findSolution() {
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == word.charAt(0)) {
					dfs(i, j, 0);
				}
			}
		}
		
		if(foundFlag) {
			System.out.println("Word found");
		} else {
			System.out.println("Word not found");
		}
		
	}
	
	public void dfs(int i, int j, int index) {

		if(index == word.length()) {
			foundFlag = true;
			return;
		}
		
		if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
			return;
		} 
		else {
			char temp = board[i][j];
			board[i][j] = ' ';
			dfs(i + 1, j, index + 1);
			dfs(i - 1, j, index + 1);
			dfs(i, j + 1, index + 1);
			dfs(i, j - 1, index + 1);
			board[i][j] = temp;
		}
	}

}
