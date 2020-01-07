package com.xinping.leetcode.solutions;

import junit.framework.TestCase;

public class LongestValidParenthesesTest extends TestCase {

    public void testLongestValidParentheses1() {
        String s = "(()())";
        LongestValidParentheses parentheses = new LongestValidParentheses();
        assertEquals(6, parentheses.longestValidParentheses1(s));
    }
}