package com.xinping.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArraysII {

    /**
     * 暴力
     * <p>
     * 11ms, 8.29%
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        boolean[] mask = new boolean[nums1.length];
        ArrayList<Integer> result = new ArrayList<>();

        for (int value : nums2) {
            for (int j = 0; j < nums1.length; j++) {
                if (!mask[j] && nums1[j] == value) {
                    result.add(value);
                    mask[j] = true;
                    break;
                }
            }
        }

        int[] r = new int[result.size()];

        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    /**
     * 排序
     * <p>
     * 2ms, 99.62%
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] r = new int[result.size()];

        for (i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}
