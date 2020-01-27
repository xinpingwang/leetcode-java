package com.xinping.leetcode.solutions;

public class ProductOfArrayExceptSelf {

    /**
     * 暴力法
     * <p>
     * 2433ms, 5.14%
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int p = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    p *= nums[j];
                }
            }
            result[i] = p;
        }

        return result;
    }

    /**
     * 左右乘积表
     * <p>
     * 2ms, 41.92%
     */
    public int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];

        int[] productLeft = new int[nums.length];
        int[] productRight = new int[nums.length];

        productLeft[0] = 1;
        productRight[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            productLeft[i] = productLeft[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            productRight[i] = productRight[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = productLeft[i] * productRight[i];
        }

        return result;
    }

    /**
     * 用 result 来记录右乘积表，一个数来记录左乘积
     * <p>
     * 1ms, 100%
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        int productLeft = 1;

        result[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] *= productLeft;
            productLeft *= nums[i];
        }

        return result;
    }
}
