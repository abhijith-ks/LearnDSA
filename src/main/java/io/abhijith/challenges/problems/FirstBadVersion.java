package io.abhijith.challenges.problems;

/**
 * Given n versions [1,2,3,4,5....n]. Find out the first bad one
 * isBad() function returns whether a version is bad or not
 * 
 * Minimize the number of calls to the API
 * 
 * @author abhijith-ks
 *
 */

public class FirstBadVersion {
	
	public void findSolution(int n) {
		
		int left = 1;
		int right = n;
		
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(!isBad(mid)) {
				left = mid + 1; 
			} else {
				right = mid;
			}
		}
		
		System.out.println(left);
		
	}
	
	public boolean isBad(int n) {
		if(n >= 3)
			return true;
		else
			return false;
	}

}
