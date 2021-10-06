package io.abhijith.challenges.search_and_sort;

public class CountingSort {
	
	int[] a = {4,2,1,0,0,5,4,7,9,3};
	
	public void findSolution() {
	
		int largest = 0;
		
//		Find the largest
		for(int i = 0; i < a.length; i++) {
			if(a[i] > largest) {
				largest = a[i];
			}
		}
		
//		Create and initialize count array with size = largest + 1 and value = 0
		int count[] = new int[largest + 1];
		for(int i = 0; i <= largest; i++) {
			count[i] = 0;
		}
		
//		Add the count of each value in count array
		for(int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}
		
//		Aggregate the count value by index
		for(int i = 1; i <= largest; i++) {
			count[i] += count[i-1];
		}
		
//		Create the final array
//		Traverse the main array backwards
//		For each element, find the value in count array -> value - 1 is the position for the current element in final array
//		Place it in the final array and decrement the value in count array (For the duplicate entries)
		int finalArray[] = new int[a.length];
		for(int i = a.length - 1; i >= 0; i--) {
			finalArray[ count[ a[i] ] - 1 ] = a[i];
			count[a[i]]--;
		}
		
//		Print the sorted array
		for(int i: finalArray) {
			System.out.println(i);
		}
		
	}

}
