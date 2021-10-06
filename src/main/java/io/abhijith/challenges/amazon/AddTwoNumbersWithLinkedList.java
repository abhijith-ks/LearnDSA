package io.abhijith.challenges.amazon;

import io.abhijith.resources.ListNode;

/**
 * Given two numbers represented by two lists, write a function that returns the sum list.
 * The sum list is list representation of the addition of two input numbers.
 *
 * Input:
 * List1: 5->6->3 // represents number 365
 * List2: 8->4->2 // represents number 248
 * Output:
 * Resultant list: 3->1->6 // represents number 613
 */

public class AddTwoNumbersWithLinkedList {

    public void findSolution() {

        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(8);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(2);

        ListNode resultNode = new ListNode(-1);
        ListNode iterator = resultNode;
        int carry = 0;

        while(node1 != null || node2 != null) {
            int sum = 0;
            if(node1 == null) {
                sum = node2.val + carry;
                node2 = node2.next;
            }
            else if(node2 == null) {
                sum = node1.val + carry;
                node1 = node1.next;
            }
            else {
                sum = node1.val + node2.val + carry;
                node1 = node1.next;
                node2 = node2.next;
            }
            iterator.next = new ListNode(sum % 10);
            carry = sum / 10;
            iterator = iterator.next;
        }

        if(carry != 0) {
            iterator.next = new ListNode(1);
        }

        resultNode = resultNode.next;
        while(resultNode != null) {
            System.out.print("\t" + resultNode.val);
            resultNode = resultNode.next;
        }

    }

}
