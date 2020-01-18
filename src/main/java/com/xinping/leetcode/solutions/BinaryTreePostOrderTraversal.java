package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {

    /**
     * 递归
     * <p>
     * 0ms, 100%
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        traversal(result, root);

        return result;
    }

    void traversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(result, root.left);
        traversal(result, root.right);
        result.add(root.val);
    }
}
