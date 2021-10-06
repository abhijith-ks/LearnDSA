package io.abhijith.challenges.linkedlist;

/**
 * Detect loop in a linked list
 * 
 * @author abhijith-ks
 */

import java.util.HashSet;
import java.util.Set;

import io.abhijith.resources.ListNode;

public class DetectLoopInLinkedList {
	
	public void findSolution() {
		ListNode headNode = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		headNode.next = a;
		a.next = b;
		b.next = c;
		c.next = headNode;
		
		ListNode node = headNode;
		Set<ListNode> set = new HashSet<>();
		
		while(node != null){
			if(set.contains(node)) {
				System.out.println("Loop detected");
				return;
			}
			set.add(node);
			
			node = node.next;
		}
		System.out.println("Loop not detected");
	}

}
