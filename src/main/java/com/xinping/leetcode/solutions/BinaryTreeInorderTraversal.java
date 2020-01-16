package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    /**
     * 递归
     * <p>
     * 1ms, 71.50%
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traversal(root, result);
        return result;
    }

    void traversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        traversal(node.left, result);
        result.add(node.val);
        traversal(node.right, result);
    }
}
