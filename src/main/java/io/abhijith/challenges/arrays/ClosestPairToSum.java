package io.abhijith.challenges.arrays;

/**
 * Given two array and a number
 * Select one number from each array such that the absolute difference between the pair and given number is minimal
 * O(nlogn)
 * @author abhijith-ks
 */

import java.util.Arrays;

public class ClosestPairToSum {
	
	public void findSolution(int a[], int b[], int number) {
		
		int sortedA[] = new int[a.length];
		int sortedB[] = new int[b.length];
		
		sortedA = Arrays.copyOf(a, a.length);
		sortedB = Arrays.copyOf(b, b.length);
		
		Arrays.sort(sortedA);
		Arrays.sort(sortedB);
				
		int i = a.length-1, j = 0;
		int copyNumber = Integer.MAX_VALUE, copyI = i, copyJ = j, numVar;
		
		while(i >= 0 && j < b.length ) {
			numVar = (sortedA[i] + sortedB[j]);
			if(numVar == number) {
				copyI = sortedA[i];
				copyJ = sortedB[j];
				System.out.println("{"+ copyI +" , "+ copyJ +" }");
				return;
			}
			else {
				if(Math.abs(number - numVar) < copyNumber) {
					copyNumber = Math.abs(number-numVar);
					copyI = sortedA[i];
					copyJ = sortedB[j];
				}
				if(numVar < number)
					j++;
				else
					i--;
			}
		}
		System.out.println("{ "+ copyI +" , "+ copyJ +" }");
	}

}
