package io.abhijith.resources;

public class BinaryTreeNode {
	
	String val;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode() {	
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public BinaryTreeNode(String val, BinaryTreeNode left, BinaryTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
}


//
//BinaryTreeNode root = new BinaryTreeNode("5", 
//		new BinaryTreeNode("4", 
//				new BinaryTreeNode("11",
//						new BinaryTreeNode("7", null, null),
//						new BinaryTreeNode("2", null, null)
//						), null), 
//		new BinaryTreeNode("8", 
//				new BinaryTreeNode("13", null, null),
//				new BinaryTreeNode("4",null,
//						new BinaryTreeNode("1", null, null)
//						)
//				)
//		);

//*       5
//*      / \
//*     4   8
//*    /   / \
//*   11  13 14
//*  / \      \
//* 7   2      1
