package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {

    /**
     * 递归
     * <p>
     * 0ms, 100%
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        traversal(result, root);

        return result;
    }

    void traversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        traversal(result, root.left);
        traversal(result, root.right);
    }
}
