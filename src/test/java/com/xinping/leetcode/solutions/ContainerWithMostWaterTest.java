package com.xinping.leetcode.solutions;

import junit.framework.TestCase;

public class ContainerWithMostWaterTest extends TestCase {

    public void testMaxArea() {
        ContainerWithMostWater container = new ContainerWithMostWater();
        int[] testcase = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, container.maxArea(testcase));
    }
}