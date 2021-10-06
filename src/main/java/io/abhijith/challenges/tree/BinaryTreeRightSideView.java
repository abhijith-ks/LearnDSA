package io.abhijith.challenges.tree;

/**
 * Given a binary tree, imagine yourself standing on the right side of it.
 * Return the values of the nodes you can see ordered from top to bottom
 * 
 * @author abhijith-ks
 */

import java.util.LinkedList;
import java.util.Queue;

import io.abhijith.resources.BinaryTreeNode;

public class BinaryTreeRightSideView {
	
	BinaryTreeNode root = new BinaryTreeNode("1",
							new BinaryTreeNode("2",
									null,
									new BinaryTreeNode("5", null, null)),
							new BinaryTreeNode("3",
									null,
									new BinaryTreeNode("4", null, null)));
	
	public void findSolution() {
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				BinaryTreeNode current = queue.remove();
				if(i == size - 1) {
					System.out.println(current.getVal());
				}
				if(current.getLeft() != null) {
					queue.add(current.getLeft());
				}
				if(current.getRight() != null) {
					queue.add(current.getRight());
				}
			}
		}
		
		
	}

}
