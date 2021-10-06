package io.abhijith.challenges.problems;

/**
 * Given a string of round, curly and square open and closing brackets
 * Return whether the brackets are balanced (well-formed)
 * 
 * Example: ([])[]({}) => well formed, ([)] => not well formed
 * 
 * @author abhijith-ks
 * 
 */

import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
	
	Stack<Character> stack = new Stack<Character>();
	HashMap<Character, Character> hmap = new HashMap<Character, Character>();

	public void findSolution(String input) {
		
		hmap.put(']', '[');
		hmap.put(')', '(');
		hmap.put('}', '{'); 
		
		for(int i=0;i<input.length();i++) {
			if(stack.empty()) {
				stack.push(input.charAt(i));
			}
			else {
				if(stack.lastElement() == hmap.get(input.charAt(i))) {
					stack.pop();
				}
				else {
					stack.push(input.charAt(i));
				}
			}
		}

		if(stack.empty()) {
			System.out.println("Balanced");
		}
		else {
			System.out.println("Not Balanced");
		}
		
	}
	
}
