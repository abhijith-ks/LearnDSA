package io.abhijith.challenges.linkedlist;

import io.abhijith.resources.ListNode;

/**
 * Reverse a linkedlist
 */

public class ReverseLinkedList {

    ListNode node1 = new ListNode(-1);

    public void findSolution() {
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(6);
        node1.next.next.next = new ListNode(7);
        node1.next.next.next.next = new ListNode(1);

        ListNode head = node1.next;
        while(head != null) {
            System.out.print("\t" + head.val);
            head = head.next;
        }

        reverseLinkedlist(node1);

        System.out.println();
        head = node1;
        while(head.next != null) {
            System.out.print("\t" + head.val);
            head = head.next;
        }

    }

    public void reverseLinkedlist(ListNode node) {
        if(node.next == null) {
            node1 = node;
            return;
        }
        reverseLinkedlist(node.next);
        ListNode tempNode;
        tempNode = node.next;
        tempNode.next = node;
        node.next = null;
    }

}
