package io.abhijith.challenges.tree;

/**
 * Construct a Binary Tree from Postorder and Inorder
 */

public class BinaryTreeFromPostOrderInOrder {

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    class PostIndex {
        int index;
    }

    public void findSolution() {
        int[] inorder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postOrder = {8, 4, 5, 2, 6, 7, 3, 1};

        int inStart = 0;
        int inEnd = inorder.length - 1;
        PostIndex postIndex = new PostIndex();
        postIndex.index = postOrder.length - 1;

        Node root = createBinaryTree(postOrder, inorder, 0, inorder.length - 1, postIndex);
        inorderTraversal(root);
    }

    public Node createBinaryTree(int[] post, int[] in, int inStart, int inEnd, PostIndex postIndex) {
        if(inStart > inEnd) {
            return null;
        }
        Node node = new Node(post[postIndex.index]);
        (postIndex.index)--;
        if(inStart == inEnd) {
            return node;
        }
        int nextIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(in[i] == node.value) {
                nextIndex = i;
                break;
            }
        }
        node.right = createBinaryTree(post, in, nextIndex + 1, inEnd, postIndex);
        node.left = createBinaryTree(post, in, inStart, nextIndex - 1, postIndex);
        return  node;
    }

    public void inorderTraversal(Node node) {
        if(node == null)
            return;
        inorderTraversal(node.left);
        System.out.print(" " + node.value);
        inorderTraversal(node.right);
    }

}
