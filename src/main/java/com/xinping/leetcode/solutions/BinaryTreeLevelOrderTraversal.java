package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    /**
     * 队列
     * <p>
     * 1ms, 98.79%
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);
        int current = 1, next = 0;

        List<Integer> itemList = new ArrayList<>();


        while (queue.peek() != null) {

            TreeNode node = queue.poll();
            itemList.add(node.val);
            current--;

            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            if (current == 0) {
                result.add(itemList);
                itemList = new ArrayList<>();
                current = next;
                next = 0;
            }
        }

        return result;
    }

    /**
     * 递归
     * <p>
     * 1ms, 98.79%
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, root, 0);

        return result;
    }

    void helper(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level == result.size()) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }

        result.get(level).add(node.val);
        helper(result, node.left, level + 1);
        helper(result, node.right, level + 1);
    }
}
