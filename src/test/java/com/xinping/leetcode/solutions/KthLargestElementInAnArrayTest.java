package com.xinping.leetcode.solutions;

import junit.framework.TestCase;

public class KthLargestElementInAnArrayTest extends TestCase {

    public void testFindKthLargest2() {
        int[] nums = new int[]{3, 1, 2, 4};
        int k = 2;

        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();

        assertEquals(3, kthLargestElementInAnArray.findKthLargest2(nums, 2));
    }
}