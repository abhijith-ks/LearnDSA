package io.abhijith.challenges.problems;

/**
 * Given a set of non-negative integers, and a value sum, 
 * determine if there is a subset of the given set with sum equal to given sum.
 * 
 * @author abhijith-ks
 */

public class SetOfNumbersAddToTotal {

	int arr[] = new int[] {2,4,6,10};
	int total = 11;
	
	public void findSolution() {
		
		System.out.println(findSets(arr.length-1, total));
		
	}
	
	public boolean findSets(int i, int total) {
		
		if(total == 0)
			return true;
		if(i < 0 && total != 0 )
			return false;
		if(total < arr[i]) 
			return findSets(i-1, total);
		else
			return findSets(i-1, total) || findSets(i-1, total - arr[i]);
		
	}

}
