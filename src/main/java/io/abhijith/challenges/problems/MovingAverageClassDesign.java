package io.abhijith.challenges.problems;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Design a class can deal with sliding window
 * 
 * @author abhijith-ks
 */

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageClassDesign {
	
	Queue<Integer> queue;
	private int size;
	private double sum;

	public MovingAverageClassDesign(int size) {
		queue = new LinkedList<>();
		this.size = size;
		sum = 0;
	}
	
	public void next(int val) {
		
		if(queue.size() == size) {
			sum -= queue.remove();
		}
		
		queue.add(val);
		
		sum += val;
		
		System.out.println(sum/queue.size());
	}
	
}
