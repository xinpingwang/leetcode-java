package com.xinping.leetcode.solutions;

public class LongestTurbulentSubarray {

    /**
     * 暴力
     * <p>
     * 超时
     */
    public int maxTurbulenceSize(int[] A) {
        if (A.length < 2) {
            return A.length;
        }

        if (A.length == 2 && A[0] != A[1]) {
            return 2;
        }

        int maxLength = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                // 如果 i 到 j 已经不满足条件，则后面的也不用继续了
                if (!isTurbulentArray(A, i, j)) {
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    boolean isTurbulentArray(int[] A, int start, int end) {
        boolean result1 = true, result2 = true;

        for (int i = start; i < end; i++) {
            if ((i % 2 == 0 && A[i] >= A[i + 1]) || (i % 2 == 1 && A[i] <= A[i + 1])) {
                result1 = false;
            }
            if ((i % 2 == 0 && A[i] <= A[i + 1]) || (i % 2 == 1 && A[i] >= A[i + 1])) {
                result2 = false;
            }
        }

        return result1 || result2;
    }


    /**
     * Turbulence 数组的实际上是大小关系交错的数组
     * <p>
     * 7ms, 82.97%
     */
    public int maxTurbulenceSize1(int[] A) {
        if (A.length < 2) {
            return A.length;
        }

        int maxLen = 1, start = 0, status = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                start = i;
                status = 0;
            } else if (A[i - 1] < A[i]) {
                if (status != 1) {
                    maxLen = Math.max(maxLen, i - start + 1);
                } else {
                    start = i - 1;
                }
                status = 1;
            } else {
                if (status != -1) {
                    maxLen = Math.max(maxLen, i - start + 1);
                } else {
                    start = i - 1;
                }
                status = -1;
            }
        }

        return maxLen;
    }
}
