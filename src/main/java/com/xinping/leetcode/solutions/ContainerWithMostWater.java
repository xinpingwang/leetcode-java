package com.xinping.leetcode.solutions;

public class ContainerWithMostWater {

    /**
     * 从两端向中间收缩容器的宽度，每次收缩较低的
     * <p>
     * 6ms, 40.43%
     */
    public int maxArea(int[] height) {
        int max = 0;

        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(area, max);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
