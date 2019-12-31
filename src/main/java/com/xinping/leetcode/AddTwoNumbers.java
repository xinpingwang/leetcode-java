package com.xinping.leetcode;

public class AddTwoNumbers {

    /**
     * 本题同[合并两个有序的链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)类似，都可以通过递归或循环进行实现
     * <p>
     * 2ms, 99.96%
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = null;
        ListNode l1Ptr = l1, l2Ptr = l2, resultListPtr = null;

        int to = 0;

        while (l1Ptr != null && l2Ptr != null) {
            int val = l1Ptr.val + l2Ptr.val + to;
            ListNode node;

            if (val >= 10) {
                to = 1;
                val -= 10;
            } else {
                to = 0;
            }
            node = new ListNode(val);

            if (resultList == null) {
                resultList = node;
                resultListPtr = resultList;
            } else {
                resultListPtr.next = node;
                resultListPtr = resultListPtr.next;
            }

            l1Ptr = l1Ptr.next;
            l2Ptr = l2Ptr.next;
        }

        ListNode remain = l1Ptr == null ? l2Ptr : l1Ptr;

        while (remain != null) {
            int val = remain.val + to;
            if (val >= 10) {
                to = 1;
                val -= 10;
            } else {
                to = 0;
            }

            ListNode node = new ListNode(val);
            if (resultList == null) {
                resultList = node;
                resultListPtr = resultList;
            } else {
                resultListPtr.next = node;
                resultListPtr = resultListPtr.next;
            }
            remain = remain.next;
        }

        if (to == 1) {
            resultListPtr.next = new ListNode(1);
        }

        return resultList;
    }
}
