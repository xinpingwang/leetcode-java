package com.xinping.leetcode.solutions;

public class MinimumPathSum {

    /**
     * dp, 二维数组
     * <p>
     * 3ms
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int h = grid.length, w = grid[0].length;

        int[][] sum = new int[h][w];

        sum[0][0] = grid[0][0];

        for (int i = 1; i < h; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < w; j++) {
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[h - 1][w - 1];
    }

    /**
     * dp，一维数组
     * <p>
     * 2ms, 98.94%
     */
    public int minPathSum1(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int h = grid.length, w = grid[0].length;

        int[] dp = new int[w];
        dp[0] = grid[0][0];

        for (int j = 1; j < w; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < h; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < w; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        return dp[w - 1];
    }
}
