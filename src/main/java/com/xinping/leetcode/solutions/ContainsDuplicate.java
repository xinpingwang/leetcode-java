package com.xinping.leetcode.solutions;

import java.util.HashSet;

public class ContainsDuplicate {

    /**
     * 暴力
     * <p>
     * 332ms, 12.23%
     */
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 哈希表
     * <p>
     * 10ms, 72.54%
     */
    public boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return set.size() != nums.length;
    }
}
