package com.xinping.leetcode.solutions;

public class MajorityElement {

    /**
     * 投票法
     * <p>
     * 2ms, 85.68%
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
            } else {
                count += nums[i] == result ? 1 : -1;
            }
        }
        return result;
    }
}
