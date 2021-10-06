package io.abhijith.challenges.tree;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * 
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * 
 * @author abhijith-ks
 */

import io.abhijith.resources.BinaryTreeNode;

public class SameTree {
	
	BinaryTreeNode p = new BinaryTreeNode("1",
						new BinaryTreeNode("2", null, null),
						new BinaryTreeNode("3", null, null));
	BinaryTreeNode q = new BinaryTreeNode("1",
						new BinaryTreeNode("2", null, null), 
						new BinaryTreeNode("3", null, null));
	
	public void findSolution() {
		
		System.out.println(checkTrees(p, q));
		
	}
	
	public boolean checkTrees(BinaryTreeNode p, BinaryTreeNode q) {
		
		if(p == null && q == null) {
			return true;
		} else if(p == null || q == null){
			return false;
		}
		
		if(Integer.parseInt(p.getVal()) != Integer.parseInt(q.getVal())) {
			return false;
		}
		
		return checkTrees(p.getLeft(), q.getLeft()) && checkTrees(p.getRight(), q.getRight());
	}

}
