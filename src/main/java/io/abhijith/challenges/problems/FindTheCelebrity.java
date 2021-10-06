package io.abhijith.challenges.problems;

/**
 * Suppose you are at a party with n people (labeled from 0 to n-1) and among them, there may exist one celebrity.
 * The definition of celebrity is that all other n-1 people know him/her but he/she does not any of them.
 * 
 * You are given a helper function boolean knows(a,b) which tells you whether A knows B.
 * Find out the celebrity by using minimum number of calls to knows(int, int) api
 * 
 * @author abhijith-ks
 */

public class FindTheCelebrity {

	public void findSolution(int n) {
		 
		int candidate = 0;
		for(int i = 1; i < n; i++) {
			if(knows(candidate, i)) {
				candidate = i;
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(i != candidate && knows(candidate, i) || !knows(i, candidate)) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(candidate);
	}
	
	public boolean knows(int a, int b) {
		if(b == 3) {
			return true;
		}
		return false;
	}
	
}
