package io.abhijith.challenges.problems;

/**
 * We have a list of points on the plane. Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * Return the answer in any order
 * 
 * @author abhijith-ks
 */

import java.util.PriorityQueue;

public class KClosestPointToOrigin {
	
	int[][] points = new int[][] {{1,3}, {-2,2}, {0,0}, {1,-1}, {3,5}};
	int k = 3;
	
	public void findSolution() {
		
		if(points.length == 0 || points == null) {
			System.out.println("Invalid input");
			return;
		}
		
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>( (a,b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]) );
		
		for(int i = 0; i < points.length; i++) {
			maxHeap.add(points[i]);
			if(maxHeap.size() > k) {
				maxHeap.remove();
			}
		}
		
		while(maxHeap.size() != 0) {
			for(int i:maxHeap.remove()) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
