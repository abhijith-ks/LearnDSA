package io.abhijith.challenges.arrays;

/**
 * Given a circularly sorted array.
 * Find the pivot element
 * 
 * O(logn)
 * 
 * @author abhijith-ks
 *
 */

public class CircularSortedPivotElement {
	
	public void findSolution() {
		
		int[] a = new int[] {12,14,18,21,3,6,8,9};
		
		if(a.length == 0 || a == null) {
			System.out.println(-1);
			return;
		}
		
		if(a[0] < a[a.length-1]) {
			System.out.println(-1);
			return;
		}
		
		int low = 0;
		int high = a.length - 1;
		
		while(low <= high) {
			
			int mid = (high + low) / 2;
			
			if(a[mid] > a[mid+1] && mid < a.length-1) {
				System.out.println(a[mid + 1]);
				return;
			}
			if(a[mid] < a[low]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
			
		}
		
	}

}
