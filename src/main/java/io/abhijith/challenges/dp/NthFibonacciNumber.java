package io.abhijith.challenges.dp;

/**
 * Given a position in fibonacci series
 * Find the fibonacci number in the postion
 * 
 * 1. Recursion approach
 * 2. Dynamic Programming approach
 * 3. BottumUp approach
 * 
 * @author abhijith-ks
 *
 */

public class NthFibonacciNumber {
	
	public void findSolution(int n) {
		
		System.out.println(fibonacci(n));
		
		int a[] = new int[n+1];
		System.out.println(fibMemoized(n, a));
		
		System.out.println(fibBottomUp(n));
		
	}
	
//	Normal Recursion solution
//	O(n^2)
	public int fibonacci(int n) {
		if(n==1 || n==2)
			return 1;
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}
	
//	Dynamic Programming with Recursion using memoized approach (Saving intermediate result)
//	O(2n) => O(n)
	public int fibMemoized(int n, int memo[]) {
		if(memo[n] != 0)
			return memo[n];
		else if(n==1 || n==2)
			return 1;
		else {
			memo[n] = fibMemoized(n-1, memo) + fibMemoized(n-2, memo);
			return memo[n];
		}
	}
	
//	Bottum Up approach using an array to store the fibonacci series until nth element
//	O(n)
	public int fibBottomUp(int n) {
		if(n==1 || n==2)
			return 1;
		else {
			int arr[] = new int[n+1];
			arr[1] = 1;
			arr[2] = 1;
			for(int i=3; i<=n; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
			return arr[n];
		}
	}
		
}
