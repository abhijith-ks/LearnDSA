package io.abhijith.challenges.string;

/**
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -
 * You and your friend take turns to flip two consecutive ++ into --
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * 
 * Write a function to compute all possible states if the string after one valid move.
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
	
	String s = "++++";
	
	public void findSolution() {
		
		List<String> list = new ArrayList<>();
		
		for(int i = 1; i < s.length(); i++) {
			char[] temp = s.toCharArray();
			if(temp[i] == '+' && temp[i-1] == '+'){
				temp[i] = '-';
				temp[i-1] = '-';
				list.add(new String(temp));
			}
		}
		
		for(String s: list) {
			System.out.println(s);
		}
		
	}

}
