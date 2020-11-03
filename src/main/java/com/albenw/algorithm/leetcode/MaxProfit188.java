package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020-08-30.
 * leetcode 122
 */
@Slf4j
public class MaxProfit188 {

    /**
     * 只允许两次买卖，但是同一时刻只能买入一次
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices){
        return dpMethod(k, prices);
    }

    /**
     * 参考122
     * dp[i][j][k]定义，其中k为第i天之前总共买卖了k次
     * @param prices
     * @return
     */
    private int dpMethod(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        //初始化第0天
        for(int kk = 0; kk <= k; kk++) {
            dp[0][kk][0] = 0;
            dp[0][kk][1] = -prices[0];
        }
        for(int i = 1; i < n; i++) {
            for(int j = k; j > 0; j--){
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        int res = 0;
        for(int r = 0; r <= k; r++){
            res = Math.max(dp[n - 1][r][0], res);
        }
        return res;
    }

    @Test
    public void test() {
        MaxProfit188 maxProfit = new MaxProfit188();
        int[] prices = new int[]{3,2,6,5,0,3};
        int i = maxProfit.maxProfit(2, prices);
        assert i == 7;
    }

}
