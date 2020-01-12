package com.xinping.leetcode.solutions;

public class FirstBadVersion {

    /**
     * 二分：注意计算中间值的方式
     * <p>
     * 16ms, 18.65%
     */
    public int firstBadVersion(int n) {

        int left = 1, right = n;
        while (left < right) {
            // 如果 left 和 right 的值都比较大，则 (left + right) / 2 可能会越界
            int middle = left + (right - left) / 2;
            // 当前版本是坏的
            if (isBadVersion(middle)) {
                if (middle > 1 && !isBadVersion(middle - 1)) {
                    return middle;
                } else {
                    right = middle - 1;
                }
            } else { // 当前版本是好的
                left = middle + 1;
            }
        }

        return left;
    }

    boolean isBadVersion(int n) {
        return false;
    }
}
