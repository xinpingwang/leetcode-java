package com.xinping.leetcode.solutions;

import junit.framework.TestCase;

public class ReverseStringIITest extends TestCase {

    public void testReverseStr() {
        String str = "abcdefg";
        String reversed = "bacdfeg";

        ReverseStringII reverse = new ReverseStringII();
        assertEquals(reversed, reverse.reverseStr(str, 2));
    }
}