package com.xinping.leetcode.solutions;

public class ReverseInteger {
    /**
     * 直接求解
     * 2ms, 56.25%
     */
    public int reverse(int x) {
        String MIN_VALUE = "-2147483648";
        String MAX_VALUE = "2147483647";
        char[] chars = String.valueOf(x).toCharArray();
        int startIndex = chars[0] == '-' ? 1 : 0;

        for (int i = startIndex; i < chars.length; i++) {
            int lastIndex = chars.length - 1 - i + startIndex;
            if (i >= lastIndex) {
                break;
            }
            char temp = chars[i];
            chars[i] = chars[lastIndex];
            chars[lastIndex] = temp;
        }

        String reversedStr = String.valueOf(chars);

        // 越界判断
        if (startIndex == 0 && reversedStr.length() == MAX_VALUE.length() && reversedStr.compareTo(MAX_VALUE) > 0) {
            return 0;
        }

        if (startIndex == 1 && reversedStr.length() == MIN_VALUE.length() && reversedStr.compareTo(MIN_VALUE) > 0) {
            return 0;
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}
