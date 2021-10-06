package io.abhijith.challenges.tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced tree is defined as a binary tree,
 * in which the depth of the two subtrees of every node never differ by more than 1
 * 
 * @author abhijith-ks
 */

import io.abhijith.resources.BinaryTreeNode;

public class SortedArrayToBalancedBST {
	
	public void findSolution(int a[]) {
		
		if(a.length == 0 || a == null)
			return;
		
		BinaryTreeNode btn = recursiveBST(a, 0, a.length-1);
		System.out.println(btn.getRight().getRight().getVal());
		System.out.println(btn.getLeft().getRight().getVal());
		
	}
	
	public BinaryTreeNode recursiveBST(int a[], int left, int right) {
		
		if(left > right)
			return null;
		
		int mid = left + (right - left) / 2;
		BinaryTreeNode current = new BinaryTreeNode();
		current.setVal(a[mid] + "");
		current.setLeft(recursiveBST(a, left, mid-1));
		current.setRight(recursiveBST(a, mid+1, right));

		return current;
	}

}
