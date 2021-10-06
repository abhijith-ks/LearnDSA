package io.abhijith.challenges.tree;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * ie, from left to right, level by level
 * 
 * Basically implement Breadth First Search and list as levels
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import io.abhijith.resources.BinaryTreeNode;

public class LevelOrderTraversalBT {
	
	public void findSolution() {
		
		BinaryTreeNode root = new BinaryTreeNode("3",
									new BinaryTreeNode("9", null, null),
									new BinaryTreeNode("20",
											new BinaryTreeNode("15", null, null),
											new BinaryTreeNode("7", null, null)));
		
		List<List<String>> result = new ArrayList<>();
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<String> currentList = new ArrayList<>();
			
			for(int i = 0; i < size; i++) {
				BinaryTreeNode current = queue.remove();
				currentList.add(current.getVal());
				if(current.getLeft() != null) {
					queue.add(current.getLeft());
				}
				if(current.getRight() != null) {
					queue.add(current.getRight());
				}
			}
			result.add(currentList);
		}
		
		System.out.println(result);
		
	}

}
