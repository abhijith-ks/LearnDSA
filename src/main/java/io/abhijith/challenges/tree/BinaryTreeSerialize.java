package io.abhijith.challenges.tree;

/**
 * Given the root to a binary tree, implement serialize(root), 
 * which serializes the tree into a string, 
 * and deserialize(s), which deserializes the string back into the tree.
 * 
 * For example, given the following Node class
 * 
 * class Node:
 *  def __init__(self, val, left=None, right=None):
 *          self.val = val
 *          self.left = left
 *          self.right = right
 *          
 *          The following test should pass:          
 *node = Node('root', Node('left', Node('left.left')), Node('right'))
 *assert deserialize(serialize(node)).left.left.val == 'left.left'
 *
 *@author abhijith-ks
 */

import java.util.ArrayList;

import io.abhijith.resources.BinaryTreeNode;

public class BinaryTreeSerialize {
	ArrayList<String> str = new ArrayList<>();
 	
	public void findSolution(BinaryTreeNode node) {
		serialize(node);
		// Test Serialization Result
		System.out.println(str);
		BinaryTreeNode bnt = deSerialize(str, 0);
		// Test Deserialization Result (Expected output left.left)
		System.out.println(bnt.getLeft().getLeft().getVal());
	}
	
	public void serialize(BinaryTreeNode node) {
		if(node == null) {
			str.add("-1 ");
			return;
		}
		str.add(node.getVal() + " ");
		serialize(node.getLeft());
		serialize(node.getRight());
	}
	
	public BinaryTreeNode deSerialize(ArrayList<String> marker, int i) {
		if(marker.get(i) == "-1 ") {
			return null;
		}
		BinaryTreeNode node = new BinaryTreeNode();
		node.setVal(marker.get(i));
		node.setLeft(deSerialize(marker, i+1));
		node.setRight(deSerialize(marker, i+2));
		
		return node;
	}
	
}
