package io.abhijith.challenges.arrays;

/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * To order elements can be changed. It doesn't matter what you leave beyond the new length
 * 
 * Example: arrays = {0,1,2,2,3,0,4,2} and value = 2
 * return: {0,1,3,0,4} in any order
 * 
 * @author abhijith-ks
 *
 */

public class RemoveElement {
	
	public void findSolution(int a[], int val) {
		
		int index = 0;
		
		for(int i: a) {
			if(i != val) {
				a[index++] = i;
			}
		}
		
		for(int i = 0; i < index; i++) {
			System.out.println(a[i]);
		}
		
//		int lpointer = a.length - 1;
//		for(int i = 0; i <= lpointer; i++) {
//			if(a[i] == val) {
//				while(a[lpointer] == val) {
//					lpointer--;
//				}
//				a[i] = a[lpointer--];
//			}
//		}
//		
//		System.out.println("New Length : " + (lpointer + 1));
//		
//		for(int i = 0; i < lpointer + 1; i++) {
//			System.out.println(a[i]);
//		}
		
	}

}
