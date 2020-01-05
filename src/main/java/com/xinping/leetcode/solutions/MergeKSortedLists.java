package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.ListNode;

public class MergeKSortedLists {

    /**
     * 转化为合并两个有序链表
     * <p>
     * 218ms, 18.23%
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode result = lists[0];

        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }

    /**
     * 分治或归并，将列表两两合并
     * <p>
     * 3ms, 86.85%
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {

            ListNode[] result = new ListNode[(lists.length + 1) / 2];

            for (int i = 0; i + 1 < lists.length; i = i + 2) {
                ListNode merged = mergeTwoLists(lists[i], lists[i + 1]);
                result[i / 2] = merged;
            }

            if (lists.length % 2 == 1) {
                result[result.length - 1] = lists[lists.length - 1];
            }
            lists = result;
        }

        return lists[0];
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
