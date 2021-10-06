package io.abhijith.challenges.string;

/**
 * Given two strings, return if they are equal when both are typed to an empty editor.
 * '#' means a backspace character
 * 
 * @author abhijith-ks
 */

import java.util.Stack;

public class BackSpaceStringCompare {

	public void findSolution(String s1, String s2) {
		
		s1 = "a#c";
		s2 = "b";
		
		Stack<Character> st1 = new Stack<>();
		Stack<Character> st2 = new Stack<>();
		
		for(int i=0; i < s1.length();i++) {
			if(s1.charAt(i) != '#') {
				st1.push(s1.charAt(i));
			} else {
				if(!st1.empty())
					st1.pop();
			}
		}
		
		for(int i=0; i < s2.length();i++) {
			if(s2.charAt(i) != '#') {
				st2.push(s2.charAt(i));
			} else {
				if(!st2.empty())
					st2.pop();
			}
		}
		
		if(st1.size() != st2.size()) {
			System.out.println("Strings are not equal");
			return;
		}
		
		while(!st1.empty()) {
			if(st1.pop() != st2.pop()) {
				System.out.println("Strings are not equal");
				return;
			}
		}
		
		System.out.println("Strings are equal");
	}
	
}
