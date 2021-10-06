package io.abhijith.challenges.tree;

/**
 * Given a binary tree and a sum, find all 'root-to-leaf' paths where each path's sum equals the given sum.
 * 
 * @author abhijith-ks
 */

import java.util.ArrayList;
import java.util.List;

import io.abhijith.resources.BinaryTreeNode;

public class PathSumTwo {
	
	int sum = 22;
	BinaryTreeNode root = new BinaryTreeNode("5",
							new BinaryTreeNode("4",
									new BinaryTreeNode("11",
											new BinaryTreeNode("7", null, null),
											new BinaryTreeNode("2", null, null)),
									null),
							new BinaryTreeNode("8",
									new BinaryTreeNode("13", null, null),
									new BinaryTreeNode("4",
											new BinaryTreeNode("5", null, null),
											new BinaryTreeNode("1", null, null))));
	
	public void findSolution() {
		
		List<List<Integer>> paths = new ArrayList<>();
		
		findPaths(root, sum, new ArrayList<Integer>(), paths);
		
		for(List<Integer> l: paths) {
			System.out.println(l);
		}
		
	}
	
	public void findPaths(BinaryTreeNode root, int sum, List<Integer> list, List<List<Integer>> paths) {
		
		if(root == null) {
			return;
		}
		
		list.add(Integer.parseInt(root.getVal()));
		if(Integer.parseInt(root.getVal()) == sum && root.getLeft() == null && root.getRight() == null) {
			paths.add(list);
			return;
		}
		
		findPaths(root.getLeft(), sum - Integer.parseInt(root.getVal()), new ArrayList<Integer>(list), paths);
		findPaths(root.getRight(), sum - Integer.parseInt(root.getVal()), new ArrayList<Integer>(list), paths);
	}

}
