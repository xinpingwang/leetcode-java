package com.xinping.leetcode.solutions;

public class ImplementStrStr {

    /**
     * 暴力法
     * <p>
     * 3ms, 41.30%
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        boolean find;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            find = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return i;
            }
        }

        return -1;
    }

    // TODO: KMP 算法
}
