package io.abhijith.challenges.linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author abhijith-ks
 */

import io.abhijith.resources.ListNode;

public class MergeTwoSortedLinkedList {
	
	ListNode l1 = new ListNode(1);
	ListNode l2 = new ListNode(1);

	ListNode l3 = new ListNode(-1);
	ListNode head = l3;
	
	public void findSolution() {
		
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		
		while(l1 != null) {
			head.next = l1;
			l1 = l1.next;
		}
		
		while(l2 != null) {
			head.next = l2;
			l2 = l2.next;
		}
		
		l3 = l3.next;
		while(l3 != null) {
			System.out.print(l3.val + " ");
			l3 = l3.next;
		}
		
	}

}
