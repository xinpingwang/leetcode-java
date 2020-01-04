package com.xinping.leetcode.solutions;

import java.util.*;

public class ThreeSum {

    /**
     * 暴力法
     * <p>
     * 超时
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        HashSet<String> strings = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        StringBuilder sb = new StringBuilder();
                        for (Integer integer : list) {
                            sb.append(integer);
                        }
                        if (!strings.contains(sb.toString())) {
                            lists.add(list);
                            strings.add(sb.toString());
                        }
                    }
                }
            }
        }

        return lists;
    }

    /**
     * 排序 + 双指针 参考解题：
     * https://leetcode-cn.com/problems/3sum/solution/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
     * <p>
     * 36ms, 71.08%
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            // 前面已经找过 nums[i] 可能的组合，现在不用再找了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    // 跳过重复的（必须）
                    do {
                        left++;
                    } while (left < nums.length && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (right > left && nums[right] == nums[right + 1]);
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
