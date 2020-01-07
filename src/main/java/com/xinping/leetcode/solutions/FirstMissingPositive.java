package com.xinping.leetcode.solutions;

public class FirstMissingPositive {

    /**
     * 标志位，非常数空间
     * <p>
     * 1ms, 98.79%
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        int result = 0;
        int[] m = new int[nums.length];

        for (int num : nums) {
            if (num > 0 && num <= m.length) {
                m[num - 1] = 1;
            }
        }

        for (int i = 0; i < m.length; i++) {
            if (m[i] == 0) {
                return i + 1;
            }
        }

        return m.length + 1;
    }
}
