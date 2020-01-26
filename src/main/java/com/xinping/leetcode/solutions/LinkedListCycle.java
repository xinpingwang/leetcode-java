package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.ListNode;

public class LinkedListCycle {

    /**
     * 快慢指针法
     * <p>
     * 0ms, 100%
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
