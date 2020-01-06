package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.ListNode;

public class ReverseNodesInKGroup {

    /**
     * 结合反转链表中指定位置的方式
     * <p>
     * 1ms, 78.10%
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        for (int i = 1; i + k - 1 <= length; i += k) {
            reverseBetween(head, i, i + k - 1);
        }
        return head;
    }

    ListNode reverseBetween(ListNode head, int m, int n) {

        int i = 0; // 记录当前遍历过的节点数

        ListNode prePtr = null; // 记录需要反转部分的前驱
        // 找到需要反转列表的前驱：第 m-1 个节点
        while (i < m - 1) {
            if (prePtr == null) {
                prePtr = head;
            } else {
                prePtr = prePtr.next;
            }
            i++;
        }

        // 找到第 m 个节点
        ListNode nodeM = prePtr == null ? head : prePtr.next; // 第 m 个节点
        i = m;

        // 开始反转，pre 记录当前要反转节点的前一个节点
        ListNode pre = null, current = nodeM;

        // 反转 m 到 n-1 个节点，结束时 current 指向 nodeN
        while (i < n) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
            i++;
        }

        // 处理第 N 个节点，如果前驱不为 null，则将前驱的 next 设为当前节点，否则，将当前节点设置为 head
        if (prePtr != null) {
            prePtr.next = current;
        } else {
            head = current;
        }

        // 设置第 M 个节点的后继为 当前节点的后继
        nodeM.next = current.next;

        // 如果存在前一个节点，则当前节点的后继为前一个节点
        if (pre != null) {
            current.next = pre;
        }

        return head;
    }
}
