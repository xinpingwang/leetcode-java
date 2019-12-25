package com.xinping.leetcode;

public class RemoveDuplicatesFromSortedArray {

    /**
     * 双指针
     * <p>
     * 1ms, 100%
     */
    public int removeDuplicates(int[] nums) {
        int nIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[nIndex]) {
                nIndex++;
                nums[nIndex] = nums[i];
            }
        }

        return nIndex + 1;
    }
}
