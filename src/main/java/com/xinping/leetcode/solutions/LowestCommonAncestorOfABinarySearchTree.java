package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * 公共父节点 >= 较小的，<= 较大的
     * <p>
     * 7ms, 87.20%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 确保 p 的值比 q 的小
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        TreeNode result = root;

        while (result.val > q.val || result.val < p.val) {
            if (result.val > q.val) {
                result = result.left;
            } else {
                result = result.right;
            }
        }

        return result;
    }
}
