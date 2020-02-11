package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

public class ConstructBinaryTreeFromPreOrderAndInorderTraversal {

    /**
     * 递归
     * <p>
     * 14ms, 46.46%
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int m, int n) {
        if (i == j) {
            return null;
        }

        int root = preorder[i];
        int rootIndexInInorder = find(inorder, m, n, root);
        int leftLength = rootIndexInInorder - m;

        TreeNode rootNode = new TreeNode(root);
        rootNode.left = buildTree(preorder, i + 1, i + 1 + leftLength, inorder, m, m + leftLength);
        rootNode.right = buildTree(preorder, i + 1 + leftLength, j, inorder, rootIndexInInorder + 1, n);

        return rootNode;
    }

    int find(int[] array, int s, int e, int key) {
        for (int i = s; i < e; i++) {
            if (array[i] == key) {
                return i;
            }
        }

        return -1;
    }
}
