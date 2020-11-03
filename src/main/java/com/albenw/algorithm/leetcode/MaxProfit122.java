package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020-08-30.
 * leetcode 122
 */
@Slf4j
public class MaxProfit122 {

    /**
     * 允许多次买卖，但是同一时刻只能买入一次
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        return dpMethod(prices);
    }

    /**
     * 想法有点像贪心，如果第二天收益>0，则卖出累加总收益。通过画出折线图可以看出每次卖出的收益是等效于最高-最低的。
     * 这个一般比较难想到
     * @param prices
     * @return
     */
    private int addSum(int[] prices){
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i - 1];
            if(diff > 0){
                sum += diff;
            }
        }
        return sum;
    }

    /**
     * dp
     * 定义dp[i]为到第i天的最大利润，dp[i][0]为第i天没有持有股票（即卖出股票），dp[i][1]为第i天持有股票（即买入股票）
     * @param prices
     * @return
     */
    private int dpMethod(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    @Test
    public void test() {
        MaxProfit122 maxProfit = new MaxProfit122();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int i = maxProfit.maxProfit(prices);
        log.info("i={}", i);
    }

}
