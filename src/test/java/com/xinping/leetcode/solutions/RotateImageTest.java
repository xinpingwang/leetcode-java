package com.xinping.leetcode.solutions;

import junit.framework.TestCase;

public class RotateImageTest extends TestCase {

    public void testRotate() {
        int[][] data = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(data);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                assertEquals(result[i][j], data[i][j]);
            }
        }
    }
}