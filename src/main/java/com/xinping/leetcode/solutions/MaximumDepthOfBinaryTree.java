package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

public class MaximumDepthOfBinaryTree {

    /**
     * 递归
     * <p>
     * 0ms, 100%
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
