package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

    /**
     * 同 binary-tree-level-order-traversal，增加了顺序调整
     * <p>
     * 1ms， 100%
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> item = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int current = 1, next = 0;

        while (queue.peek() != null) {
            TreeNode node = queue.remove();
            current--;

            item.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            if (current == 0) {
                result.add(item);
                item = new ArrayList<>();
                current = next;
                next = 0;
            }
        }

        for (int i = 0, j = result.size() - 1; i < j; i++, j--) {
            List<Integer> temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
        }

        return result;
    }
}
