package io.abhijith.challenges.tree;

/**
 * Given a binary tree, check whether it is symmetric
 * 
 * @author abhijith-ks
 */

import io.abhijith.resources.BinaryTreeNode;

public class SymmetricTree {
	
	BinaryTreeNode root = new BinaryTreeNode("1", 
								new BinaryTreeNode("2", 
										new BinaryTreeNode("3",null, null),
										new BinaryTreeNode("4", null, null)), 
								new BinaryTreeNode("2", 
										new BinaryTreeNode("4",null, null),
										new BinaryTreeNode("3", null, null))
								);
	
	public void findSolution() {
		
		System.out.println(traverse(root.getLeft(), root.getRight()));
		
	}
	
	public boolean traverse(BinaryTreeNode left, BinaryTreeNode right) {
		
		if(left == null && right == null) {
			return true;
		} else if(left == null || right == null) {
			return false;
		}
		
		if(left.getVal() != right.getVal()) {
			return false;
		}
		
		return traverse(left.getLeft(), right.getRight()) && traverse(left.getRight(), right.getLeft());
	}

}
