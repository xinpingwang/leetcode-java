package com.xinping.leetcode.solutions;

import java.util.Stack;

public class TrappingRainWater {

    /**
     * 两个数组分别记录当前元素左端最高和右端最高
     * <p>
     * 1ms, 99.98%
     */
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int max = 0;

        for (int i = 1; i < height.length; i++) {
            max = Math.max(max, height[i - 1]);
            maxLeft[i] = max;
        }

        max = 0;
        for (int i = height.length - 2; i > 0; i--) {
            max = Math.max(max, height[i + 1]);
            maxRight[i] = max;
        }

        int result = 0;

        for (int i = 0; i < height.length; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                result += min - height[i];
            }
        }

        return result;
    }

    /**
     * 将上述算法优化为使用一个数来记录当前节点左侧的最大值
     * <p>
     * 1ms, 99.98%
     */
    public int trap1(int[] height) {
        int[] maxRight = new int[height.length];

        int max = 0, maxLeft = 0;

        for (int i = height.length - 2; i > 0; i--) {
            max = Math.max(max, height[i + 1]);
            maxRight[i] = max;
        }

        int result = 0;

        for (int i = 1; i < height.length; i++) {
            maxLeft = Math.max(maxLeft, height[i - 1]);
            int min = Math.min(maxLeft, maxRight[i]);
            if (min > height[i]) {
                result += min - height[i];
            }
        }

        return result;
    }

    /**
     * 进一步优化上述算法为双指针
     * <p>
     * 1ms, 99.98%
     */
    public int trap2(int[] height) {
        int maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length - 1;

        int result = 0;

        while (left < right) {
            // 左侧的最大值小于右侧的最大值
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    result += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    result += maxRight - height[right];
                }
                right--;
            }
        }

        return result;
    }

    /**
     * 栈
     * <p>
     * 7ms, 32.27%
     */
    public int trap3(int[] height) {
        // 保存索引
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                // 获取当前栈顶元素对应的值
                int h = height[stack.pop()];
                if (stack.empty()) {
                    break;
                }

                int distance = i - stack.peek() - 1;
                int min = Math.min(height[i], height[stack.peek()]);
                result += distance * (min - h);
            }
            // 记录坑底的高度
            stack.push(i);
        }

        return result;
    }
}
