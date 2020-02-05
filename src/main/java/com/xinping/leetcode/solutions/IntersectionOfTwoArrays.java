package com.xinping.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    /**
     * 哈希
     * <p>
     * 3ms, 95.90%
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        int i = 0;
        int[] r = new int[result.size()];
        for (int num : result) {
            r[i] = num;
            i++;
        }

        return r;
    }
}
