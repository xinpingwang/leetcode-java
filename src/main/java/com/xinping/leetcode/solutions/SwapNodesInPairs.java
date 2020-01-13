package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.ListNode;

public class SwapNodesInPairs {

    /**
     * 双指针, dummy 节点
     * <p>
     * 0ms, 100%
     */
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, after = head;

        int i = 1;
        while (after != null) {
            after = after.next;
            i++;
            // after 为奇数时，交换 pre 和 after 中间的节点
            if (i > 1 && i % 2 == 1) {
                // 第二个节点的 next 指向 第一个节点
                pre.next.next.next = pre.next;
                // pre 的 next 指向 第二个节点
                pre.next = pre.next.next;
                // 第一个节点的 next 指向 after
                pre.next.next.next = after;
                // pre 向后移动两格
                pre = pre.next.next;
            }
        }

        return dummy.next;
    }
}
