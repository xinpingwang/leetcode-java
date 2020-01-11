package com.xinping.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

    /**
     * 暴力法
     * <p>
     * 92ms, 9.35%
     */
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;

        // 记录每个数字出现的次数，以及最大次数
        for (int num : nums) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
            maxCount = Math.max(maxCount, counts.get(num));
        }

        int minLength = nums.length;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == maxCount) {
                int lenght = lastIndex(nums, entry.getKey()) - firstIndex(nums, entry.getKey()) + 1;
                minLength = Math.min(minLength, lenght);
            }
        }

        return minLength;
    }

    int firstIndex(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }

        return nums.length - 1;
    }

    int lastIndex(int[] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target == nums[i]) {
                return i;
            }
        }

        return 0;
    }


    /**
     * 暴力法：同时记录当前数字数次出现的次数，以及开始和结束位置
     * <p>
     * 70ms, 18.36%
     */
    public int findShortestSubArray1(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> counts = new HashMap<>();
        int maxCount = 0, minLength = nums.length;

        // 记录每个数字出现的次数，以及最大次数
        for (int i = 0; i < nums.length; i++) {
            if (counts.containsKey(nums[i])) {
                ArrayList<Integer> list = counts.get(nums[i]);
                list.set(0, list.get(0) + 1);
                list.set(2, i);
                counts.put(nums[i], list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(i);
                list.add(i);
                counts.put(nums[i], list);
            }

            if (counts.get(nums[i]).get(0) > maxCount) {
                maxCount = counts.get(nums[i]).get(0);
                minLength = counts.get(nums[i]).get(2) - counts.get(nums[i]).get(1) + 1;
            } else if (counts.get(nums[i]).get(0) == maxCount) {
                minLength = Math.min(minLength, counts.get(nums[i]).get(2) - counts.get(nums[i]).get(1) + 1);
            }
        }

        return minLength;
    }
}
