package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.ListNode;

public class RemoveNthNodeFromEndOfList {

    /**
     * 前一个节点向前移动 n+1，然后连个节点同时移动，到前一个节点移动到链表的末尾
     * dummy 节点的使用，减少较多的判断
     * <p>
     * 1ms, 50.57%
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, current = dummy;
        while (n >= 0) {
            pre = pre.next;
            n--;
        }

        while (pre != null) {
            pre = pre.next;
            current = current.next;
        }

        current.next = current.next.next;

        return dummy.next;
    }
}
