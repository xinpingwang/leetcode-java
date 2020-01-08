package com.xinping.leetcode.solutions;

import junit.framework.TestCase;

public class TrappingRainWaterTest extends TestCase {

    public void testTrap() {
        int[] testInput = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = 6;
        TrappingRainWater trap = new TrappingRainWater();
        assertEquals(result, trap.trap3(testInput));
    }
}