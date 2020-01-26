package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.ListNode;

public class LinkedListCycleII {

    /**
     * 快慢指针法，第一轮循环确定是否存在环及环的大小，第二轮确定节点
     * <p>
     * 1ms, 55.28%
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        int fastStep = 1;
        int slowStep = 0;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;
            fastStep += 2;
            slowStep++;
        }

        // 快指针比慢指针多跑了一个环
        int cycleLen = fastStep - slowStep;
        fast = head;
        slow = head;
        while (cycleLen != 0) {
            fast = fast.next;
            cycleLen--;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 双指针
     * <p>
     * 0ms, 100%
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        System.out.println(fast.val);
        System.out.println(slow.val);
        // 相遇位置到环的入口，与 head 到入口的距离一致
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
