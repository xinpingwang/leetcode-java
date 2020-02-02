package com.xinping.leetcode.solutions;

import junit.framework.TestCase;

public class MultiplyStringsTest extends TestCase {

    public void testMultiply() {
        String num1 = "123", num2 = "456";
        String result = "56088";

        MultiplyStrings multiplyStrings = new MultiplyStrings();
        assertEquals(result, multiplyStrings.multiply(num1, num2));
    }
}