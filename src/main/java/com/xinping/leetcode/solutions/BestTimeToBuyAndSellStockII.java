package com.xinping.leetcode.solutions;

public class BestTimeToBuyAndSellStockII {

    /**
     * 只要比前一天的加个高，就可以有一份交易
     * <p>
     * 1ms, 99.98%
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}
