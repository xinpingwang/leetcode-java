package com.xinping.leetcode.solutions;

public class PowerOfTwo {

    /**
     * 除 2 并判断余数
     * <p>
     * 1ms, 100%
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }

        return true;
    }

    /**
     * 位运算
     * <p>
     * 1ms, 100%
     */
    public boolean isPowerOfTwo1(int n) {
        if (n < 1) {
            return false;
        }

        int m = n - 1;
        return (m & n) == 0;
    }
}
