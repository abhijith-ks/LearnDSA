package io.abhijith.challenges.tree;

/**
 * Given a binary tree, return the postorder traversal of its nodes value
 * Use iterative approach
 * 
 * @author abhijith-ks
 */

import io.abhijith.resources.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversalBTIterative {
	
	public void findSolution() {
		BinaryTreeNode root = new BinaryTreeNode("1",
									null,
									new BinaryTreeNode("2",
											null, 
											new BinaryTreeNode("3", null, null)));
		
		List<String> list = new ArrayList<>();
		Stack<BinaryTreeNode> stack = new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			BinaryTreeNode node = stack.pop();
			list.add(0, node.getVal()); // because of parameter '0', list will put the element in the beginning and push the rest to the right 
			if(node.getLeft() != null) {
				stack.push(node.getLeft());
			}
			if(node.getRight() != null) {
				stack.push(node.getRight());
			}
		}
		
		System.out.println(list);
		twoStackSolution(root);
	}

	private void twoStackSolution(BinaryTreeNode node) {
		Stack<BinaryTreeNode> s1 = new Stack<>();
		Stack<BinaryTreeNode> s2 = new Stack<>();

		s1.push(node);
		while(! s1.isEmpty()) {
			BinaryTreeNode current = s1.pop();
			s2.push(current);
			if(current.getLeft() != null)
				s1.push(current.getLeft());
			if(current.getRight() != null)
				s1.push(current.getRight());
		}

		while(!s2.isEmpty()) {
			System.out.print("\t" + s2.pop().getVal());
		}
	}

}
