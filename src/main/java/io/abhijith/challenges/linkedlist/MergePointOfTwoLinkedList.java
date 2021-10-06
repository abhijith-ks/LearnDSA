package io.abhijith.challenges.linkedlist;

import io.abhijith.resources.ListNode;

import java.util.List;

/**
 * Find the merge point for two linkedlists
 */

public class MergePointOfTwoLinkedList {

    ListNode node1 = new ListNode(8);
    ListNode node2 = new ListNode(2);

    public void findSolution() {

        node1.next = new ListNode(4);
        node1.next.next = new ListNode(6);
        node1.next.next.next = new ListNode(7);
        node1.next.next.next.next = new ListNode(1);

        node2.next = new ListNode(9);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(5);
        node2.next.next.next.next = node1.next.next.next;


        int count1 = 0, count2 = 0;
        ListNode head1 = node1;
        ListNode head2 = node2;

        while (node1 != null) {
            count1++;
            node1 = node1.next;
        }

        System.out.println();
        while (node2 != null) {
            count2++;
            node2 = node2.next;
        }

        ListNode mergePoint;

        if(count1 > count2) {
            int diff = count1 - count2;
            for (int i = 0; i < diff; i++) {
                head1 = head1.next;
            }
        } else {
            int diff = count2 - count1;
            for (int i = 0; i < diff; i++) {
                head2 = head2.next;
            }
        }

        while(head1 != null && head2 != null) {
            if(head1 == head2) {
                System.out.println(head1.val);
                return;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        System.out.println(-1);
    }

}
