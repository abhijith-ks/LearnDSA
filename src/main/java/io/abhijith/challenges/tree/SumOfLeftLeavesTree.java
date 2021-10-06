package io.abhijith.challenges.tree;

/**
 * Find the sum of all left leaves of a given binary tree
 * 
 * @author abhijith-ks
 */

import io.abhijith.resources.BinaryTreeNode;

public class SumOfLeftLeavesTree {
	
	public int sum = 0;
	
	public void findSolution() {
		
		BinaryTreeNode root = new BinaryTreeNode("3",
								new BinaryTreeNode("9", null, null),
								new BinaryTreeNode("20",
										new BinaryTreeNode("15", null, null),
										new BinaryTreeNode("7", null, null)));
		
		System.out.println( findSum(root) );
		
	}
	
	public int findSum(BinaryTreeNode node) {
		
		if(node == null) {
			return 0;
		}
		else if(node.getLeft() != null && node.getLeft().getLeft() == null && node.getLeft().getRight() == null) {
			return Integer.parseInt(node.getLeft().getVal()) + findSum(node.getRight());
		}
		else {
			return findSum(node.getLeft()) + findSum(node.getRight());
		}
		
	}

}
