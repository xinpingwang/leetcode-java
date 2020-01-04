package com.xinping.leetcode.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {

    /**
     * 暴力法，组合输入数组中的每两个数
     * <p>
     * 28ms, 33.11%
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 哈希表，这种解法要求输入数组中不能有重复的元素
     * <p>
     * 6 ms, 62.69%
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                result[0] = i;
                result[1] = map.get(complement);
                break;
            }
        }
        return result;
    }

    /**
     * 按值对索引排序
     * <p>
     * 5ms, 65.15%
     */
    public int[] twoSum2(final int[] nums, int target) {
        int[] result = new int[2];

        Integer[] indexes = new Integer[nums.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (num1, num2) -> nums[num1] - nums[num2]);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[indexes[i]] + nums[indexes[j]];
            if (sum == target) {
                result[0] = indexes[i];
                result[1] = indexes[j];
                return result;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
