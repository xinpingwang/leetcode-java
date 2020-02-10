package com.xinping.leetcode.solutions;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 二分
     * <p>
     * 0ms, 100%
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                result[0] = middle;
                right = middle - 1;
            }
        }

        if (result[0] == -1) {
            return result;
        }

        left = 0;
        right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                result[0] = middle;
                left = middle + 1;
            }
        }

        return result;
    }
}
