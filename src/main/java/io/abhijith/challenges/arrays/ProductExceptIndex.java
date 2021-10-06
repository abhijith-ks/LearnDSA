package io.abhijith.challenges.arrays;

/**
 * Given an array of integers
 * Return new array such that each element at index i of the new array is the product
 * of all elements in the original array except the one at i
 * Bonus: Solution without division operation
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;

public class ProductExceptIndex {
	
	public void findSolution(int a[]) {
		
//		Method with less space complexity
		int prod = 1;
		for(int i = 0; i < a.length; i++) 
			prod *= a[i];
		
		for(int i=0; i < a.length; i++)
			a[i] = prod / a[i];
		System.out.println(Arrays.toString(a));
		
		
//		Different method, without using division operator
		/*
		int[] a1 = Arrays.copyOf(a, a.length), a2 = Arrays.copyOf(a, a.length);
		
		for(int i=1, j = a.length-2; i < a.length; i++, j--) {
			a1[i] = a1[i] * a1[i-1];
			a2[j] = a2[j] * a2[j+1];
		}
		
		int b[] = new int[a.length];
		int l,r;
		for(int i=0; i < a.length; i++) {
			l = (i == 0) ? 1 : a1[i-1];
			r = (i == a.length-1) ? 1 : a2[i+1];
			b[i] = l * r;
		}
		System.out.println(Arrays.toString(b));
		*/
	}
	
}
