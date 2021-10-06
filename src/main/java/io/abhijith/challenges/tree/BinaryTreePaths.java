package io.abhijith.challenges.tree;

/**
 * Given a binary tree, return all root-to-leaf paths
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.List;

import io.abhijith.resources.BinaryTreeNode;

public class BinaryTreePaths {
	
	BinaryTreeNode node = new BinaryTreeNode("1",
								new BinaryTreeNode("2",
										null,
										new BinaryTreeNode("5", null, null)),
								new BinaryTreeNode("3", null, null));
	
	public void findSolution() {
		
		List<String> retList = new ArrayList<>();
		findPaths(node, retList, "");
		
		System.out.println(retList);
		
	}
	
	public void findPaths(BinaryTreeNode node, List<String> retList, String str) {
		if(str.length() != 0) {
			str += " -> ";
		}
		str += node.getVal();
		
		if(node.getLeft() == null && node.getRight() == null) {
			retList.add(str);
			return;
		}
		
		if(node.getLeft() != null) {
			findPaths(node.getLeft(), retList, str);
		}
		
		if(node.getRight() != null) {
			findPaths(node.getRight(), retList, str);
		}
		
		
	}
	

}
