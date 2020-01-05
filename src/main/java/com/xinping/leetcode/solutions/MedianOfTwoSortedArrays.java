package com.xinping.leetcode.solutions;

public class MedianOfTwoSortedArrays {

    /**
     * 遍历
     * <p>
     * 3ms, 98.14%
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalLength = nums1.length + nums2.length;

        int sortedLength = 0;
        int median = 0, i = 0, j = 0;

        while (sortedLength < totalLength / 2) {
            if (j == nums2.length || (i < nums1.length && nums1[i] < nums2[j])) {
                median = nums1[i];
                i++;
            } else {
                median = nums2[j];
                j++;
            }
            sortedLength++;
        }

        int next = i < nums1.length && j < nums2.length ? Math.min(nums1[i], nums2[j]) : i < nums1.length ? nums1[i] : nums2[j];

        if (totalLength % 2 == 0) {
            return (median + next) / 2.0;
        } else {
            return next;
        }
    }

    /**
     * 二分，转化为求第 k 小的数字
     * <p>
     * 3ms, 98.11%
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;

        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int mindVal1 = i + k / 2 - 1 < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mindVal2 = j + k / 2 - 1 < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (mindVal1 < mindVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
