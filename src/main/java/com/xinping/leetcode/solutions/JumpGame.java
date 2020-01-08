package com.xinping.leetcode.solutions;

public class JumpGame {

    /**
     * 回溯法
     * <p>
     * 超时
     */
    public boolean canJump(int[] nums) {

        return backtrack(nums, 0);
    }

    boolean backtrack(int[] nums, int position) {
        // 当前位置在终点
        if (position == nums.length - 1) {
            return true;
        }

        // 站在当前位置可能跳跃到的最远位置
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int i = furthestJump; i > position; i--) {
            if (backtrack(nums, i)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 动态规划
     * <p>
     * 254ms, 17.71%
     */
    public boolean canJump1(int[] nums) {
        // 记录每个位置是否能跳到终点：0 不确定，1 可以，2 不可以
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (dp[j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
            if (dp[i] == 0) {
                dp[i] = 2;
            }
        }

        return dp[0] == 1;
    }

    /**
     * 从右往左，一次记录能到达终点的最左侧的节点的索引
     * <p>
     * 2ms, 62.20%
     */
    public boolean canJump2(int[] nums) {
        int mostLeft = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            if (furthestJump >= mostLeft) {
                mostLeft = i;
            }
        }

        return mostLeft == 0;
    }

    /**
     * 记录已经遍历的节点能跳跃到的最远距离，同时，如果当前节点大于最远距离，失败
     * <p>
     * 2ms, 62.20%
     **/
    public boolean canJump3(int[] nums) {

        int mostRight = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (i > mostRight) {
                return false;
            }
            mostRight = Math.max(mostRight, i + nums[i]);
        }

        return true;
    }
}
