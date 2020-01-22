package com.xinping.leetcode.solutions;

public class ReverseStringII {

    /**
     * 注意读题
     * <p>
     * 1ms, 93.15%
     */
    public String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();

        for (int start = 0; start < chars.length; start += 2 * k) {
            int l = start, r = Math.min(l + k - 1, chars.length - 1);
            while (l < r) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }

        return String.valueOf(chars);
    }
}
