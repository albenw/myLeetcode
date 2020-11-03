package com.albenw.algorithm.leetcode.dp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020-08-26.
 * leetcode 三步问题
 * ps: dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
 *
 * 假设dp(n)表示到达第n个阶梯可能的方式数；
 * 考虑倒数第二步：可以在第n-1、n-2、n-3这3个台阶上，然后一步就可以到达终点
 * 所以dp(n) = dp(n-1) + dp(n-2) + dp(n-3)
 * 初始状态容易得到：dp(1), dp(2), dp(3) = 1, 2, 4
 *
 */
@Slf4j
public class WaysToStep {

    public int waysToStep(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(n == 3) {
            return 4;
        }
        long[] f = new long[n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        for(int i = 3; i < n; i++) {
            f[i] = ((f[i-1] % 1000000007) + (f[i-2] % 1000000007) + (f[i-3] % 1000000007)) % 1000000007;
        }
        return (int)(f[n-1] % 1000000007);
    }

    @Test
    public void test1(){
        WaysToStep waysToStep = new WaysToStep();
        int i = waysToStep.waysToStep(61);
        log.info("i={}", i);
    }

}
