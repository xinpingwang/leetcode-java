package com.xinping.leetcode;


public class LongestCommonPrefix {

    /**
     * 直接遍历
     * <p>
     * 1ms, 87.08%
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        String firstStr = strs[0];

        for (int i = 0; i < firstStr.length(); i++) {
            char currentChar = firstStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return result.toString();
                }
            }
            result.append(currentChar);
        }
        return result.toString();
    }
}
