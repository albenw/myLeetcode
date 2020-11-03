package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/16.
 * leetcode 70
 */
@Slf4j
public class ClimbStairs {

    public int climbStairs(int n) {
        if(n <= 1){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    @Test
    public void tes1(){
        ClimbStairs climbStairs = new ClimbStairs();
        int i = climbStairs.climbStairs(1);
        log.info("sum={}", i);
    }

}
