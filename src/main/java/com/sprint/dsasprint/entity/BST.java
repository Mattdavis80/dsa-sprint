
package com.sprint.dsasprint.entity;

// Youtube video explaining the code and how I came up with most of this:
// https://www.youtube.com/watch?v=81PpYQ0AN_w&list=PLt4nG7RVVk1jqwwQUTByTcTcHxIlMllfy&ab_channel=CodingSimplified

public class BST {


    public String preorder(BinaryTreeNode binaryTreeNode) {
        if(binaryTreeNode == null) {
            return "Tree is empty";
        }
        StringBuilder sb = new StringBuilder();
        preorderTraversal(binaryTreeNode, sb, "Root");
        return sb.toString();
    }


    private void preorderTraversal(BinaryTreeNode node, StringBuilder sb, String label) {
        if (node == null) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(", ");
        }
        sb.append(label).append(": ").append(node.data);

        if (node.left != null) {
            preorderTraversal(node.left, sb, "Left");
        }
        if (node.right != null) {
            preorderTraversal(node.right, sb, "Right");
        }
    }

    public BinaryTreeNode insert(BinaryTreeNode binaryTreeNode, int val) {
        if(binaryTreeNode == null) {
            return createNewNode(val);
        }

        if(val < binaryTreeNode.data) {
            binaryTreeNode.left = insert(binaryTreeNode.left, val);
        } else if(val > binaryTreeNode.data) {
            binaryTreeNode.right = insert(binaryTreeNode.right, val);
        }

        return binaryTreeNode;
    }

    private BinaryTreeNode createNewNode(int k) {
        BinaryTreeNode a = new BinaryTreeNode();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }
}

