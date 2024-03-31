package com.sprint.dsasprint.entity;

public class BST {

    public String preorder(BinaryTreeNode binaryTreeNode) {
        if(binaryTreeNode == null) {
            return "null";
        }

        String leftStr = preorder(binaryTreeNode.left);
        String rightStr = preorder(binaryTreeNode.right);

        return String.format("{\"Node\":%d, \"Left\":%s, \"Right\":%s}", binaryTreeNode.data, leftStr, rightStr);
    }

    public BinaryTreeNode insert(BinaryTreeNode binaryTreeNode, int val) {
        if(binaryTreeNode == null) {
            return createNewNode(val);
        }

        if(val < binaryTreeNode.data) {
            binaryTreeNode.left = insert(binaryTreeNode.left, val);
        } else if((val > binaryTreeNode.data)) {
            binaryTreeNode.right = insert(binaryTreeNode.right, val);
        }

        return binaryTreeNode;
    }

    public BinaryTreeNode createNewNode(int k) {
        BinaryTreeNode a = new BinaryTreeNode();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }
}
