package io.abhijith.challenges.tree;

/**
 * Find the maximum depth of a Binary Tree
 * 
 * @author abhijith-ks
 */

import io.abhijith.resources.BinaryTreeNode;

public class MaxDepthBinaryTree {
	
	BinaryTreeNode root = new BinaryTreeNode("5", 
			new BinaryTreeNode("4", 
					new BinaryTreeNode("11",
							new BinaryTreeNode("7", null, null),
							new BinaryTreeNode("2", 
									new BinaryTreeNode("3", null, null), null)
							), null), 
			new BinaryTreeNode("8", 
					new BinaryTreeNode("13", null, null),
					new BinaryTreeNode("4",null,
							new BinaryTreeNode("1", null, null)
							)
					)
			);
	
	public void findSolution() {
		
		System.out.println(traverse(root));
		
	}
	
	public int traverse(BinaryTreeNode node) {
		
		if(node == null ) {
			return 0;
		}
		
		int left = traverse(node.getLeft());
		int right = traverse(node.getRight());
		return Math.max(left, right) + 1;
	}

}
