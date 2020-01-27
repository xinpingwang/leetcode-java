package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.ListNode;

public class DeleteNodeInALinkedList {

    /**
     * 将一下一个节点的值复制到当前节点，并将后一个节点删除
     * <p>
     * 0ms, 100%
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
