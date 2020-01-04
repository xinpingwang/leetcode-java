package com.xinping.leetcode.solutions;

import junit.framework.TestCase;

public class ThreeSumClosestTest extends TestCase {

    public void testThreeSumClosest() {
        int[] inputArray = {1, 1, -1, -1, 3};
        int inputTarget = -1, output = -1;

        ThreeSumClosest closest = new ThreeSumClosest();
        assertEquals(output, closest.threeSumClosest(inputArray, inputTarget));
    }
}