package com.xinping.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    /**
     * 双指针法，需要注意去重和提交结束循环的条件
     * <p>
     * 4ms, 99.57%
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int min, max;
        for (int i = 0; i < nums.length - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 提前结束条件，可以大幅降低执行时间
            min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                break;
            }

            max = nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + +nums[nums.length - 3];
            if (max < target) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                min = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min > target) {
                    break;
                }

                max = nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2];
                if (max < target) {
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[left]);
                        item.add(nums[right]);
                        result.add(item);
                        // 跳过重复的（必须）
                        do {
                            left++;
                        } while (left < right && nums[left] == nums[left - 1]);
                        do {
                            right--;
                        } while (right > left && nums[right] == nums[right + 1]);
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
