package com.xinping.leetcode;

public class LongestPalindromicSubstring {

    /**
     * 暴力法
     * <p>
     * 115ms, 23.65%
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int maxLength = 1, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 保证 j 和 i 中间的字符长度大于当前已知的最大长度，否则没必要进行判断
            for (int j = i + maxLength; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    maxLength = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    /**
     * 从中间向两边扩
     * <p>
     * 8ms, 92.93%
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数位和偶数位两种情况
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            // end 包含在回文内
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    // TODO: 最长公共子串
}
