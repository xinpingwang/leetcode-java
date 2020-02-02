package com.xinping.leetcode.solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    /**
     * 排序，并返回倒数第 k 个数
     * <p>
     * 4ms, 71.19%
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 优先队列
     * <p>
     * 5ms, 66.18%
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int num : nums) {
            int queueSize = queue.size();
            if (queueSize == k && queue.peek() >= num) {
                continue;
            }
            queue.offer(num);
            if (queueSize == k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 快排，第 k 大等价于第 N-k+1 小，寻找可以将数组划分为左边 N-k 个比他小的数
     * <p>
     * 37ms, 21.00%
     */
    public int findKthLargest2(int[] nums, int k) {
        int leftLength = -1;
        int pivotIndex = 0;
        int left = 0, right = nums.length - 1;

        while (leftLength != nums.length - k) {
            int newPivotIndex = partition(nums, left, right, pivotIndex);
            leftLength = newPivotIndex;
            if (leftLength < nums.length - k) {
                left = newPivotIndex + 1;
            }
            if (leftLength > nums.length - k) {
                right = newPivotIndex - 1;
            }
            pivotIndex = left;
        }
        return nums[leftLength];
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        pivotIndex = right;

        // move all elements smaller than pivot to left
        while (left <= right) {
            if (nums[left] >= pivot && nums[right] < pivot) {
                swap(nums, left, right);
                left++;
                right--;
            } else if (nums[left] < pivot) {
                left++;
            } else {
                right--;
            }
        }

        swap(nums, pivotIndex, left);
        return left;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
