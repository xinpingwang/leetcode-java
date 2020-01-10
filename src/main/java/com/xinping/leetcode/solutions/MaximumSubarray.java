package com.xinping.leetcode.solutions;

public class MaximumSubarray {

    /**
     * 以当前节点为终点的最大值，为以前一个节点为终点的最大值加上当前节点，或者当前节点，取决于前面节点的和是否大于 0
     * <p>
     * 1ms, 99.98%
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        int current = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = current < 0 ? nums[i] : current + nums[i];
            result = Math.max(result, current);
        }

        return result;
    }

    /**
     * 分治法
     * <p>
     * 3ms, 12.10%
     */
    public int maxSubArray1(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    int crossSum(int[] nums, int start, int end, int p) {
        if (start == end) {
            return nums[start];
        }

        int result = nums[p];
        int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;
        if (start < p) {
            int sum = 0;
            for (int i = p - 1; i >= start; i--) {
                sum += nums[i];
                maxLeft = Math.max(maxLeft, sum);
            }
        }
        if (end > p) {
            int sum = 0;
            for (int i = p + 1; i <= end; i++) {
                sum += nums[i];
                maxRight = Math.max(maxRight, sum);
            }
        }

        if (maxLeft > 0) {
            result += maxLeft;
        }
        if (maxRight > 0) {
            result += maxRight;
        }

        return result;
    }

    int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int middleIndex = (start + end) / 2;

        int maxCross = crossSum(nums, start, end, middleIndex);

        int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE;
        if (middleIndex > start) {
            maxLeft = helper(nums, start, middleIndex - 1);
        }
        if (middleIndex < end) {
            maxRight = helper(nums, middleIndex + 1, end);
        }

        return Math.max(Math.max(maxLeft, maxCross), maxRight);
    }
}
