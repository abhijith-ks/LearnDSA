package io.abhijith.challenges.tree;

/**
 * Given a binary search tree(BST), find the lowest common ancestor(LCA) of two given nodes in the BST.
 * LCA : The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * We allow a node to be a descendant itself
 * 
 *      6
 *     / \
 *    2   8
 *   / \ / \
 *  0  4 7  9
 *    /\
 *   3  5
 *   
 * @author abhijith-ks
 */

import io.abhijith.resources.BinaryTreeNode;

public class LowestCommonAncestorBST {
	
	public void findSolution() {
		BinaryTreeNode root = new BinaryTreeNode("6",
								new BinaryTreeNode("2",
										new BinaryTreeNode("0", null, null),
										new BinaryTreeNode("4",
												new BinaryTreeNode("3", null, null),
												new BinaryTreeNode("5", null, null))),
								new BinaryTreeNode("8",
										new BinaryTreeNode("7", null, null),
										new BinaryTreeNode("9", null, null)));
		int p = 5, q = 2;
		System.out.println(lowestCommonAncestor(root, p, q).getVal());
	}
	
	public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode node, int p, int q) {
		
		int nodeVal = Integer.parseInt(node.getVal());
		if(p < nodeVal && q < nodeVal) {
			return lowestCommonAncestor(node.getLeft(), p, q);
		} else if(p > nodeVal && q > nodeVal) {
			return lowestCommonAncestor(node.getRight(), p, q);
		} else {
			return node;
		}
	}

}
