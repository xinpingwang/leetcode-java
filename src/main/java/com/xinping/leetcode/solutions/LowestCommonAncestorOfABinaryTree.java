package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {

    /**
     * 找到指定节点所有的父节点
     * <p>
     * 1313ms, 5.02%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pAncestors = ancestors(root, p);
        List<TreeNode> qAncestors = ancestors(root, q);

        if (pAncestors.size() == 0 || qAncestors.size() == 0) {
            return null;
        }

        int ancestorIndex = 0;
        while (ancestorIndex < pAncestors.size() && ancestorIndex < qAncestors.size()
                && pAncestors.get(ancestorIndex) == qAncestors.get(ancestorIndex)) {
            ancestorIndex++;
        }

        return ancestorIndex > 0 ? pAncestors.get(ancestorIndex - 1) : null;
    }

    private List<TreeNode> ancestors(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        traversal(list, root, p);
        return list;
    }

    private void traversal(List<TreeNode> result, TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        if (isAncestor(root, p)) {
            result.add(root);
            traversal(result, root.left, p);
            traversal(result, root.right, p);
        }
    }

    private boolean isAncestor(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return isAncestor(root.left, p) || isAncestor(root.right, p);
    }


    TreeNode result = null;

    /**
     * 只有最近的公共祖先才有可能有左中右中的两个是 p 和 q 的父节点
     * <p>
     * 8ms, 99.76%
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return this.result;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        int left = recurseTree(root.left, p, q) ? 1 : 0;
        int right = recurseTree(root.right, p, q) ? 1 : 0;
        int middle = root == p || root == q ? 1 : 0;

        if (left + right + middle >= 2) {
            this.result = root;
        }

        return left + right + middle > 0;
    }
}
