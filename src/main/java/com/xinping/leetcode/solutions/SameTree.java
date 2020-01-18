package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

public class SameTree {

    /**
     * 递归
     * <p>
     * 0ms, 100%
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
