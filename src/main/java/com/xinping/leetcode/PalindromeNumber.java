package com.xinping.leetcode;

public class PalindromeNumber {

    /**
     * 转字符串
     * 11ms, 54.45%
     */
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int strLen = str.length();

        for (int i = 0; i < strLen / 2; i++) {
            if (str.charAt(i) != str.charAt(strLen - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取一半的反转
     * 9ms, 98.60%
     */
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNum = 0;

        while (reversedNum < x) {
            reversedNum = reversedNum * 10 + x % 10;
            x /= 10;
        }

        return reversedNum == x || reversedNum / 10 == x;
    }
}
