package io.abhijith.challenges.linkedlist;

import io.abhijith.resources.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * @author abhijith-ks
 *
 */

public class SolutionListNode {
	
	public void addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode lCopy1 = l1;
		ListNode lCopy2 = l2;
		int remainder = 0, val1, val2, sumVal;
		ListNode result = new ListNode(Integer.MAX_VALUE);
		ListNode resultCopy;
		while(lCopy1 != null || lCopy2 != null) {
			val1 = 0;
			val2 = 0;
			sumVal = 0;
			if(lCopy1 != null) {
				val1 = lCopy1.val;
				lCopy1 = lCopy1.next;
			}
			if(lCopy2 != null) {
				val2 = lCopy2.val;
				lCopy2 = lCopy2.next;
			}
			sumVal = val1 + val2 + remainder;
			if(sumVal > 9) {
				remainder = 1;
				sumVal = sumVal % 10;
			} else {
				remainder = 0;
			}
			
			resultCopy = result;
			while(resultCopy.next != null) {
				resultCopy = resultCopy.next;
			}
			resultCopy.next = new ListNode(sumVal);
		}
		if(remainder != 0) {
			resultCopy = result;
			while(resultCopy.next != null) {
				resultCopy = resultCopy.next;
			}
			resultCopy.next = new ListNode(remainder);
		}
		
		result = result.next;
		while(result != null) {
			System.out.print(result.val);
			result = result.next;
		} 
	}

}
