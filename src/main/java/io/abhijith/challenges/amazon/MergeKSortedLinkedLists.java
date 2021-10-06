package io.abhijith.challenges.amazon;

import io.abhijith.resources.ListNode;

/**
 * Merge K Sorted Linked Lists - Divide and Conquer Approach
 * Based on mergesort algorithm
 */

public class MergeKSortedLinkedLists {

    public void findSolution() {

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] listNodes = {head1, head2, head3};

        ListNode result = mergeLists(listNodes, 0, listNodes.length - 1);

        while (result != null) {
            System.out.print("\t" + result.val);
            result = result.next;
        }

    }

    private ListNode mergeLists(ListNode[] listNodes, int start, int end) {

        if (start == end) {
            return listNodes[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeLists(listNodes, start, mid);
        ListNode right = mergeLists(listNodes, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while (left != null || right != null) {
            if (left == null) {
                curr.next = right;
                right = right.next;
            } else if (right == null) {
                curr.next = left;
                left = left.next;
            } else if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        return result.next;
    }

}
