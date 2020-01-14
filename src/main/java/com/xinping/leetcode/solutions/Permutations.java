package com.xinping.leetcode.solutions;

import com.xinping.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    /**
     * 回溯
     * <p>
     * 8ms, 5.46%
     */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // backtrack(result, " ", 0, nums);

        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }

        backtrack(result, list, 0);

        return result;
    }

    void backtrack(List<List<Integer>> result, String current, int index, int[] nums) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            String[] arr = current.split(" ");
            for (String s : arr) {
                if (s.length() > 0) {
                    list.add(Integer.parseInt(s));
                }
            }
            result.add(list);
            return;
        }

        for (int num : nums) {
            if (!current.contains(" " + num + " ")) {
                backtrack(result, current + num + " ", index + 1, nums);
            }
        }
    }

    /**
     * 2ms, 53.62%
     */
    void backtrack(List<List<Integer>> result, List<Integer> current, int index) {
        if (index == current.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < current.size(); i++) {
            Collections.swap(current, index, i);
            backtrack(result, current, index + 1);
            Collections.swap(current, index, i);
        }
    }
}
