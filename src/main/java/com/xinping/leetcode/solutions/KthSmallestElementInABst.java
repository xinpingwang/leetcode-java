package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

public class KthSmallestElementInABst {

    int result;
    int count = 0;

    /**
     * 二叉搜索树的中序遍历即为从小到大的顺序
     * <p>
     * 1ms, 83.36%
     */
    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);

        return this.result;
    }

    void traversal(TreeNode node, int k) {
        if (node == null || this.count == k) {
            return;
        }

        traversal(node.left, k);
        this.count++;
        if (this.count == k) {
            this.result = node.val;
        }
        traversal(node.right, k);
    }
}
