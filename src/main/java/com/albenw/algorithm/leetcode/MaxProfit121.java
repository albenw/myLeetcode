package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020-08-30.
 * leetcode 121
 */
@Slf4j
public class MaxProfit121 {

    /**
     * 只允许做一次交易
     * 遍历一次，获取最小值的同时，求出当前值减去最小值的值，取max
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int minValue = prices[0];
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minValue){
                minValue = prices[i];
            }
            max = Math.max(prices[i] - minValue, max);
        }
        return max;
    }

    @Test
    public void test(){
        MaxProfit121 maxProfit = new MaxProfit121();
        int[] prices = new int[]{7,1,5,3,6,4};
        int i = maxProfit.maxProfit(prices);
        log.info("i={}", i);
    }

}
