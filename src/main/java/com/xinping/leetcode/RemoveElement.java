package com.xinping.leetcode;

public class RemoveElement {

    /**
     * 双指针
     * <p>
     * 0ms, 100.00%
     */
    public int removeElement(int[] nums, int val) {
        int nIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nIndex++;
                nums[nIndex] = nums[i];
            }
        }
        return nIndex + 1;
    }
}
