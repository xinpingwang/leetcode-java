package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

public class ValidateBinarySearchTree {

    /**
     * 递归，注意上下边界不能用 Integer.MAX_VALUE 和 Integer.MIN_VALUE，因为当树中真的出现这两个值的时候就会失败
     * <p>
     * 1ms, 85.83%
     */
    public boolean isValidBST(TreeNode root) {

        return helper(root, null, null) && helper(root, null, null);
    }

    // root 及其子节点的取值范围在 (min, max) 之间
    boolean helper(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        } else {
            boolean left = helper(root.left, root.val, min);
            boolean right = helper(root.right, max, root.val);
            return left && right;
        }
    }
}
