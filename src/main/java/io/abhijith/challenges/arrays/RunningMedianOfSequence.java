package io.abhijith.challenges.arrays;

/**
 * Compute the running median of a sequence of numbers
 * That is, given a stream of numbers, print out the median of the list so far on each new element
 * Recall that the median of even numbered list is the average of the two middle numbers
 * 
 * Example: Given sequence {2,1,5,7,2,0,5} output should be {2, 1.5, 2, 3.5, 2, 2, 2}
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.Collections;

public class RunningMedianOfSequence {

	public void findSolution(int a[]) {
		
		ArrayList<Double> alist = new ArrayList<>();
		
		for(int i=0; i < a.length; i++) {
			alist.add((Double) (a[i] + 0.0));
			Collections.sort(alist);
			if(alist.size() % 2 == 0) {
				System.out.println((alist.get(alist.size()/2) + (alist.get(alist.size()/2 - 1))) / 2);
			} else {
				System.out.println(alist.get(alist.size()/2));
			}
			
		}
	}
	
}
