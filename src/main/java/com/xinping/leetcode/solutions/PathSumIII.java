package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

public class PathSumIII {

    /**
     * 递归
     * <p>
     * 18ms, 37.39%
     */
    public int pathSum(TreeNode root, int sum) {
        return helper(root, root, sum);
    }

    // root 为当前路径的根节点
    private int helper(TreeNode root, TreeNode current, int sum) {
        if (current == null) {
            return 0;
        }

        int r = 0;
        if (current.val == sum) {
            r = 1;
        }

        int middle = 0, left = 0, right = 0;
        middle = helper(root, current.left, sum - current.val) +
                helper(root, current.right, sum - current.val);
        // 保证连续
        if (current == root) {
            left = helper(current.left, current.left, sum);
            right = helper(current.right, current.right, sum);
        }

        return middle + left + right + r;
    }
}
