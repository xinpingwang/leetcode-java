package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.ListNode;

public class IntersectionOfTwoLinkedLists {

    /**
     * 暴力
     * <p>
     * 603ms, 5.00%
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode nodeA = headA;
        while (nodeA != null) {
            ListNode nodeB = headB;
            while (nodeB != null) {
                if (nodeA == nodeB) {
                    return nodeA;
                }
                nodeB = nodeB.next;
            }

            nodeA = nodeA.next;
        }

        return null;
    }

    /**
     * A + all + B = B + all + A
     * <p>
     * 1ms, 100%
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode nodeA = headA, nodeB = headB;

        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }

            if (nodeB == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
        }

        return nodeA;
    }
}
