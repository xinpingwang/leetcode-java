package com.xinping.leetcode.solutions;

public class MergeSortedArray {

    /**
     * 从后往前确定，避免过多的移动操作
     * <p>
     * 0ms, 100%
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = m + n - 1;

        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[lastIndex] = nums1[m - 1];
                m--;
            } else {
                nums1[lastIndex] = nums2[n - 1];
                n--;
            }
            lastIndex--;
        }
    }
}
