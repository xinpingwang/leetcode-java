package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    /**
     * 递归
     * <p>
     * 1ms, 100%
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        traversal(result, current, root, sum);

        return result;
    }

    void traversal(List<List<Integer>> result, List<Integer> current, TreeNode node, int remain) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (remain == node.val) {
                current.add(node.val);
                result.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
            }
        }

        current.add(node.val);
        traversal(result, current, node.left, remain - node.val);
        traversal(result, current, node.right, remain - node.val);
        current.remove(current.size() - 1);
    }
}
