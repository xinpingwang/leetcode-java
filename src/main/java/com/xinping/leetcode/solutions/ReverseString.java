package com.xinping.leetcode.solutions;

public class ReverseString {

    /**
     * 双指针
     * <p>
     * 1ms, 100%
     */
    public void reverseString(char[] s) {
        for (int l = 0, r = s.length - 1; l < r; l++, r--) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
        }
    }
}
