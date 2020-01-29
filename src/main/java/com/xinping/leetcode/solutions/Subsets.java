package com.xinping.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

    /**
     * 回溯
     * <p>
     * 2ms, 11.87%
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            List<Integer> item = new ArrayList<>();
            for (int num : nums) {
                item.add(num);
            }
            helper(result, item, i, 0);
        }

        return result;
    }

    void helper(List<List<Integer>> result, List<Integer> current, int len, int i) {
        if (i == len) {
            List<Integer> list = new ArrayList<>(len);
            for (int m = 0; m < len; m++) {
                list.add(current.get(m));
            }
            result.add(list);
            return;
        }

        for (int m = i; m < current.size(); m++) {
            Collections.swap(current, i, m);
            // 保证单调递增，避免重复
            if (i == 0 || current.get(i) > current.get(i - 1)) {
                helper(result, current, len, i + 1);
            }
            Collections.swap(current, i, m);
        }
    }
}
