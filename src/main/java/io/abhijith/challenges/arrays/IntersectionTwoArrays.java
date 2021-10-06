package io.abhijith.challenges.arrays;

/**
 * Given two arrays, find the intersection of two arrays
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionTwoArrays {

	public void findSolution(int[] a1, int[] a2) {
		
		HashSet<Integer> hs = new HashSet<>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i: a1) {
			hs.add(i);
		}
		
		for(int i: a2) {
			if(hs.contains(i) && !al.contains(i)) {
				al.add(i);
			}
		}
		
		System.out.println(al);
		
	}

}
