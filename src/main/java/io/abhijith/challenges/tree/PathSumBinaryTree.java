package io.abhijith.challenges.tree;

/**
 * Given a binary tree and a sum, 
 * determine if the tree has a root to leaf path such that adding up all the value among the path equals the given sum
 * 
 * Example: sum = 22
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13 14
 *  / \      \
 * 7   2      1
 * 
 * 5->4->11->2  = 22
 * 
 * @author abhijith-ks
 * 
 */

import io.abhijith.resources.BinaryTreeNode;

public class PathSumBinaryTree {
	
	public void findSolution() {
		BinaryTreeNode root = new BinaryTreeNode("5", 
				new BinaryTreeNode("4", 
						new BinaryTreeNode("11",
								new BinaryTreeNode("7", null, null),
								new BinaryTreeNode("2", null, null)
								), null), 
				new BinaryTreeNode("8", 
						new BinaryTreeNode("13", null, null),
						new BinaryTreeNode("4",null,
								new BinaryTreeNode("1", null, null)
								)
						)
				);
		
		System.out.println(traverse(root, 22));
		
	}
	
	public boolean traverse(BinaryTreeNode node, int sum) {
		
		if( node == null ) {
			return false;
		} else if(node.getLeft() == null && node.getRight() == null && (sum - Integer.parseInt(node.getVal())) == 0) {
			return true;
		} else {
			return traverse(node.getLeft(), sum - Integer.parseInt(node.getVal())) || traverse(node.getRight(), sum - Integer.parseInt(node.getVal()));
		}
	}

}
