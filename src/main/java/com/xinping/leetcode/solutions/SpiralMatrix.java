package com.xinping.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * 模拟螺旋过程
     * <p>
     * 0ms, 100%
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int h = matrix.length, w = matrix[0].length;
        int minH = 0, minW = 0, maxH = h - 1, maxW = w - 1;

        while (result.size() < h * w) {
            // right
            for (int i = minW; i <= maxW; i++) {
                result.add(matrix[minH][i]);
            }
            minH++;
            if (minH > maxH) {
                break;
            }
            // down
            for (int i = minH; i <= maxH; i++) {
                result.add(matrix[i][maxW]);
            }
            maxW--;
            if (maxW < minW) {
                break;
            }
            // left
            for (int i = maxW; i >= minW; i--) {
                result.add(matrix[maxH][i]);
            }
            maxH--;
            // up
            for (int i = maxH; i >= minH; i--) {
                result.add(matrix[i][minW]);
            }
            minW++;
        }

        return result;
    }
}
