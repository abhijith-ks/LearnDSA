package io.abhijith.challenges.arrays;

/**
 * Find an element in a circularly sorted array
 * O(logn)
 * 
 * @author abhijith-ks
 *
 */

public class CircularSortedArray {
	
	int[] a = new int[] {12,14,18,21,3,6,8,9};
	
	public void findSolution() {
		
		int key = 12;
		
		System.out.println(binarySearch(a.length, key));
		
	}
	
	public int binarySearch(int n, int key) {
		
		int low = 0, high = n -1;
		
		while(low <= high) {
			
			int mid = (high + low) / 2;
			if(key == a[mid])
				return mid;
			
			if(a[mid] < a[high]) { // Right half is sorted
				if(key > a[mid] && key <= a[high]) { 
					low = mid + 1; // if key in the sorted half, then search space reduced to second sorted half
				} else {
					high = mid - 1; // else search space reduced to first half (may or may not be sorted)
				}
			}
			else if(a[low] < a[mid]){ // Left half is sorted
				if(key >= a[low] && key < a[mid]) {
					high = mid-1; // if key in the sorted left half, then search space reduced to first sorted half
				} else {
					low = mid + 1; // else search space reduced to second half (may or may not be sorted)
				}
			}
			// Process continues
		}
		return -1;
	}

}
