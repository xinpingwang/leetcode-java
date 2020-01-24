package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

public class PathSum {

    /**
     * 递归
     * <p>
     * 0ms, 100%
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
