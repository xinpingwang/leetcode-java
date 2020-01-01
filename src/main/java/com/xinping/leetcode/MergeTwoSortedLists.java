package com.xinping.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class MergeTwoSortedLists {

    /**
     * 递归
     * <p>
     * 1ms, 81.26%
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergedList;
        if (l1.val <= l2.val) {
            mergedList = new ListNode(l1.val);
            mergedList.next = mergeTwoLists(l1.next, l2);
        } else {
            mergedList = new ListNode(l2.val);
            mergedList.next = mergeTwoLists(l1, l2.next);
        }
        return mergedList;
    }

    /**
     * 循环
     * <p>
     * 1ms, 81.26%
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode mergedList = null;
        ListNode l1Ptr = l1, l2Ptr = l2, mergedListPtr = null;

        while (l1Ptr != null && l2Ptr != null) {
            ListNode node;
            if (l1Ptr.val <= l2Ptr.val) {
                node = new ListNode(l1Ptr.val);
                l1Ptr = l1Ptr.next;
            } else {
                node = new ListNode(l2Ptr.val);
                l2Ptr = l2Ptr.next;
            }
            if (mergedList == null) {
                mergedList = node;
                mergedListPtr = mergedList;
            } else {
                mergedListPtr.next = node;
                mergedListPtr = mergedListPtr.next;
            }
        }

        ListNode remain = l1Ptr == null ? l2Ptr : l1Ptr;

        while (remain != null) {
            ListNode node = new ListNode(remain.val);
            if (mergedList == null) {
                mergedList = node;
                mergedListPtr = mergedList;
            } else {
                mergedListPtr.next = new ListNode(remain.val);
                mergedListPtr = mergedListPtr.next;
            }
            remain = remain.next;
        }

        return mergedList;
    }
}
