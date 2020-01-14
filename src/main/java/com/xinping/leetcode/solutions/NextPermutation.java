package com.xinping.leetcode.solutions;

import java.util.Arrays;

public class NextPermutation {

    /**
     * 从后往前遍历，找到第一对顺序出现的数字
     * <p>
     * 1ms, 100%
     */
    public void nextPermutation(int[] nums) {

        for (int i = nums.length - 1; i > 0; i--) {
            // nums[i-1] 及其后面的数字需要重新排列
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }
            }
        }

        for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}
