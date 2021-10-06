package io.abhijith.challenges.tree;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 * For example, the following tree has 5 unival subtrees:
 *
 *   0
 *  / \
 * 1   0
 *    / \
 *   1   0
 *  / \
 * 1   1
 * 
 * @author abhijith-ks
 */

import io.abhijith.resources.BinaryTreeNode;

public class UniValTree {
	
	public int count = 0;
	
	public void findSolution(BinaryTreeNode btn) {
		System.out.println(countUnivals(btn));
		System.out.println(countUnivalsAnother(btn));
	}
	
	public int countUnivals(BinaryTreeNode node) {
		int totalcount = 0;
		if(node == null)
			return 0;
		
		totalcount = countUnivals(node.getLeft()) + countUnivals(node.getRight());
		if(isUnival(node))
			totalcount += 1;
		
		return totalcount;
	}

	public int countUnivalsAnother(BinaryTreeNode node) {
		if(node == null) {
			return 0;
		}
		int count = countUnivals(node.getLeft()) + countUnivals(node.getRight());
		if(isUnival(node)) return count + 1;
		else return count;
	}
	
	public boolean isUnival(BinaryTreeNode node) {
		
		if(node == null) 
			return true;

		if(node.getLeft() != null && node.getLeft().getVal() != node.getVal()) 
			return false;
		
		if(node.getRight() != null && node.getRight().getVal() != node.getVal())
			return false;
		
		if( isUnival(node.getLeft()) && isUnival(node.getRight()))
			return true;
		
		return false;
	}
	
}
