package com.xinping.leetcode.solutions;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * 双指针法
     * <p>
     * 7ms, 58.08%
     */
    public int threeSumClosest(int[] nums, int target) {

        int result = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }

                // 当前和比之前的更接近 target
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }

        return result;
    }
}
