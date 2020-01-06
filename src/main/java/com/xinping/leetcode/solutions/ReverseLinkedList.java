package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.ListNode;

public class ReverseLinkedList {

    /**
     * 循环遍历，需要同时记录当前节点和前一个节点
     * <p>
     * 0ms, 100%
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        return pre;
    }

    /**
     * 递归
     * <p>
     * 0ms, 100%
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // p 指向反转节点的开始
        ListNode p = reverseList1(head.next);
        // head.next 指向 p 链表的结尾
        head.next.next = head;
        // 防止环的出现
        head.next = null;
        return p;
    }
}
