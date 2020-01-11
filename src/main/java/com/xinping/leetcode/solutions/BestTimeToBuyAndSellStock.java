package com.xinping.leetcode.solutions;

public class BestTimeToBuyAndSellStock {

    /**
     * 暴力，每一个节点都可能买入，以后的每个时间都可能卖出
     * <p>
     * 219ms, 22.39%
     */
    public int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                result = Math.max(result, prices[j] - prices[i]);
            }
        }

        return result;
    }


    /**
     * 转换为连续数组的最大和，首先计算前一天买入，今天卖出的利润
     * <p>
     * 2 ms, 61.82%
     */
    public int maxProfit1(int[] prices) {
        int[] dp = new int[prices.length];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = prices[i] - prices[i - 1];
        }

        int maxProfit = 0, current = 0;
        for (int i = 0; i < prices.length; i++) {
            current = current > 0 ? current + dp[i] : dp[i];
            maxProfit = Math.max(maxProfit, current);
        }

        return maxProfit;
    }

    /**
     * 设当前节点卖出，记录当前节点之前的最小值，即可以获取当前加个卖出的最大利润
     * <p>
     * 1ms, 99.99%
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
