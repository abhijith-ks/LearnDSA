package io.abhijith.challenges.dp;

/**
 * Given a list of integers
 * Write a function that returns the largest sum of non-adjacent numbers
 * 
 * Dynamic Programming
 *  
 * Example: {4,1,1,4,2,1} returns 9 (4+4+1)
 * 
 * @author abhijith-ks
 *
 */

public class MaxSumSubSeqNonAdj {
	
	public void findSolution(int arr[]) {
		
		int incl = arr[0], excl = 0, temp;
		for(int i=1; i<arr.length; i++) {
			temp = incl;
			incl = Math.max(incl , (excl + arr[i]));
			excl = temp;
		}
		System.out.println(incl);
	}
	
}
