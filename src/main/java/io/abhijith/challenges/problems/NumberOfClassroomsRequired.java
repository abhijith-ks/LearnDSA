package io.abhijith.challenges.problems;

/**
 * Given an array of time intervals(start, end) for classroom lectures(possibly overlapping)
 * Find the minimum number of rooms required.
 * 
 * Example for PriorityQueue usage
 * 
 * @author abhijith-ks
 */

import java.util.Arrays;
import java.util.PriorityQueue;

import io.abhijith.resources.TimeInterval;

public class NumberOfClassroomsRequired {
	
	TimeInterval[] intervals = new TimeInterval[]{new TimeInterval(30,75),new TimeInterval(0,50), new TimeInterval(60,150)};
	
	public void findSolution() {
		
		if(intervals.length == 0) {
			System.out.println("No meetings rooms required");
			return;
		}
		
		Arrays.sort(intervals, (a,b) -> a.getBeginTime() - b.getBeginTime());
		PriorityQueue<TimeInterval> minHeap = new PriorityQueue<>((a, b) -> a.getEndTime() - b.getEndTime());
		minHeap.add(intervals[0]);
		
		for(int i=1; i<intervals.length; i++) {
			TimeInterval current = intervals[i];
			TimeInterval earliest = minHeap.remove();
			if(current.getBeginTime() >= earliest.getEndTime()) {
				earliest.setEndTime(current.getEndTime());
			}
			else {
				minHeap.add(current);
			}
			minHeap.add(earliest);
		}
		
		System.out.println("Number of meetingrooms required : " + minHeap.size());
	}

}
