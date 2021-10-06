package io.abhijith.challenges.tree;

/**
 * Implement Binary Search Tree with operations
 * insert, search, maximum element, minimum element, BFS traversal, Pre-order, In-order, Post-order, check BT is a BST and delete
 * 
 * @author abhijith-ks
 */

import java.util.LinkedList;
import java.util.Queue;

import io.abhijith.resources.BinaryTreeNode;

public class BinarySearchTree {
	
	public void findSolution() {
		
		BinaryTreeNode root = null;
		
		root = insert(root, 12);
		root = insert(root, 5);
		root = insert(root, 15);
		root = insert(root, 3);
		root = insert(root, 7);
		root = insert(root, 13);
		root = insert(root, 17);
		root = insert(root, 1);
		root = insert(root, 9);
		root = insert(root, 14);
		root = insert(root, 20);
		root = insert(root, 8);
		root = insert(root, 11);
		root = insert(root, 18);
		
		System.out.println("-----Search-----");
		System.out.println(search(root, 20));
		System.out.println(search(root, 66));
		
		System.out.println("-----Maximum-----");
		maximumElement(root);
		
		System.out.println("-----Minimum-----");
		minimumElement(root); 
		
		System.out.println("-----Height-----");
		System.out.println(findHeight(root));
		
		System.out.println("-----Breadth First - Level Order Traversal-----");
		levelOrderTraversal(root);
		
		System.out.println("-----Depth First - Preorder Traversal-----");
		preorderTraversal(root);
		
		System.out.println("-----Depth First - Inorder Traversal-----");
		inorderTraversal(root);

		System.out.println("-----Depth First - Postorder Traversal-----");
		postorderTraversal(root);
		
		System.out.println("-----Check if Binary Tree is a binary search tree");
//		root.setVal(1 +""); // Uncomment for negative test case
		System.out.println(checkBinaryTreeOrNot(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		System.out.println("-----Delete Node-----");
		int del = 15;
		System.out.println("Node to be deleted : " + del);
		root = deleteNode(root, del);
		System.out.println("Inorder Traversal after deleting : " + del);
		inorderTraversal(root);
		
	}
	
	public BinaryTreeNode deleteNode(BinaryTreeNode node, int data) {
		
		if(node == null) {
			return node;
		} else if(data < Integer.parseInt(node.getVal())) {
			node.setLeft( deleteNode(node.getLeft(), data) );
			return node;
		} else if(data > Integer.parseInt(node.getVal())){
			node.setRight( deleteNode(node.getRight(), data));
			return node;
		} else {
			
			if(node.getLeft() == null && node.getRight() == null) { // case 1: no child
				node = null;
			} else if(node.getLeft() == null) { // case 2: Single right child
				node = node.getRight();
			} else if(node.getRight() == null) { // case 2: Single left child
				node = node.getLeft();
			} else { //case 3: both left and right children
				BinaryTreeNode copy = new BinaryTreeNode(); // Getting the minimum element from the right subtree and replacing
				copy = node.getRight();
				while(copy.getLeft() != null) {
					copy = copy.getLeft();
				}
				node.setVal(copy.getVal());
				node.setRight(deleteNode(node.getRight(), Integer.parseInt(copy.getVal())));
			}
			return node;
		}
	}
	
	public boolean checkBinaryTreeOrNot(BinaryTreeNode node, int minValue, int maxValue) {
		
//		Another solution would be inorder traversal and check the elements are sorted
		
		if(node == null) {
			return true;
		} 
		
		if((Integer.parseInt(node.getVal()) < maxValue && (Integer.parseInt(node.getVal()) > minValue))
			&& checkBinaryTreeOrNot(node.getLeft(), minValue, Integer.parseInt(node.getVal()))
			&& checkBinaryTreeOrNot(node.getRight(), Integer.parseInt(node.getVal()), maxValue)){
			return true;
		}
			
		return  false;
	}
	
	public void postorderTraversal(BinaryTreeNode root) {
		if(root == null)
			return;
		
		postorderTraversal(root.getLeft());
		postorderTraversal(root.getRight());
		System.out.println(root.getVal());
	}
	
	public void inorderTraversal(BinaryTreeNode root) {
		if(root == null)
			return;
		
		inorderTraversal(root.getLeft());
		System.out.println(root.getVal());
		inorderTraversal(root.getRight());
	}

	public void preorderTraversal(BinaryTreeNode root) {
		
		if(root == null) 
			return;
			
		System.out.println(root.getVal());
		preorderTraversal(root.getLeft());
		preorderTraversal(root.getRight());
		
	}
	
	public void levelOrderTraversal(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode node = queue.remove();
			System.out.println(node.getVal());
			if(node.getLeft() != null)
				queue.add(node.getLeft());
			if(node.getRight() != null)
				queue.add(node.getRight());
		}
		
	}
	
	public int findHeight(BinaryTreeNode node) {
		if(node == null) {
			return -1;
		}
		
		return 1 + Math.max(findHeight(node.getLeft()), findHeight(node.getRight()));
	}
	
	public void minimumElement(BinaryTreeNode root) {
		if(root == null) {
			System.out.println("Empty tree");
			return;
		}
		if(root.getLeft() == null) {
			System.out.println(root.getVal());
			return;
		}
		minimumElement(root.getLeft());
	}
	
	public void maximumElement(BinaryTreeNode root) {
		if(root == null) { 
			System.out.println("Empty tree");
			return;
		}
		if(root.getRight() == null) {
			System.out.println(root.getVal());
			return;
		}
		maximumElement(root.getRight());
	}
	
	public boolean search(BinaryTreeNode root, int val) {
		
		if(root == null) {
			return false;
		}
		if(Integer.parseInt(root.getVal()) == val) {
			return true;
		}

		return search(root.getLeft(), val) || search(root.getRight(), val);
	}
	
	public BinaryTreeNode insert(BinaryTreeNode root, int val) {
		
		if(root == null) {
			root = getNode(val);
		} else if(Integer.parseInt(root.getVal()) > val) {
			root.setLeft(insert(root.getLeft(), val));
		} else {
			root.setRight(insert(root.getRight(), val));
		}
		
		return root;
	}
	
	public BinaryTreeNode getNode(int val) {
		BinaryTreeNode node = new BinaryTreeNode();
		node.setVal(val + "");
		return node;
	}

}



//Another set for tree
//--------------------
//root = insert(root, 15);
//root = insert(root, 10);
//root = insert(root, 20);
//root = insert(root, 25);
//root = insert(root, 8);
//root = insert(root, 12);
