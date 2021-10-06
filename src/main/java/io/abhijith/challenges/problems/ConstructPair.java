package io.abhijith.challenges.problems;

/**
 * cons(a, b) constructs a pair, 
 * and car(pair) and cdr(pair) returns the first and last element of that pair. 
 * For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4
 * 
 * @author abhijith-ks
 */

import io.abhijith.resources.PairStructure;

public class ConstructPair {
	
	public void findSolution(int x, int y) {
		
		PairStructure ps = cons(x,y);
		System.out.println("First Element : " + car(ps));
		System.out.println("Last Element : " + cdr(ps));
	}
	
	public PairStructure cons(int x, int y) {
		return new PairStructure(x,y);
	}
	
	public int car(PairStructure ps) {
		return ps.getX();
	}
	
	public int cdr(PairStructure ps) {
		return ps.getY();
	}
	
}
