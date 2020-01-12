package com.xinping.leetcode.solutions;

public class SearchInsertPosition {

    /**
     * 二分
     * <p>
     * 0ms, 100%
     */
    public int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        // 如果在上述过程中没有返回，那么此时 left == right
        if (left < nums.length) {
            return nums[left] < target ? left + 1 : left;
        }

        return 0;
    }
}
