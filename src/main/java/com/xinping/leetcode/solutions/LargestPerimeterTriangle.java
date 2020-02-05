package com.xinping.leetcode.solutions;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    /**
     * 两边之和大于第三边
     * <p>
     * 12ms, 78.99%
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        int i = A.length - 3;

        while (i >= 0) {
            if (A[i + 2] - A[i + 1] < A[i]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
            i--;
        }

        return 0;
    }
}
