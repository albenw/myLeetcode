package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/12/17.
 * leetcode 714. 买卖股票的最佳时机含手续费
 *
 * 跟122一样，只不过多了手续费
 * 定义dp[i][0]为第i天没有持有股票，dp[i][1]为第i天持有股票
 */
@Slf4j
public class MaxProfit714 {

    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    @Test
    public void test(){
        MaxProfit714 maxProfit714 = new MaxProfit714();
        int[] nums = new int[]{1, 3, 2, 8, 4, 9};
        int i = maxProfit714.maxProfit(nums, 2);
        log.info("i={}", i);
    }
}
