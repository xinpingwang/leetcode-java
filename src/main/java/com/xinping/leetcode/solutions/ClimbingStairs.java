package com.xinping.leetcode.solutions;

public class ClimbingStairs {

    /**
     * 递归
     * <p>
     * 超时
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 循环
     * <p>
     * 0ms, 100%
     */
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }

        int x = 1, y = 2;
        for (int i = 3; i <= n; i++) {
            int temp = x + y;
            x = y;
            y = temp;
        }
        return y;
    }
}
