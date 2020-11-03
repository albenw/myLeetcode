package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author alben.wong
 * @since 2020/10/30.
 * leetcode 279. 完全平方数
 * 第一感觉用回溯可以解决, 即dfs
 *
 * 这题跟coin change类似，可以尝试分别用dp和dfs解决
 * dp: dp[i] = min(dp[i - j*j]) + 1
 *
 * dfs
 */
@Slf4j
public class NumSquares {

    public int numSquares(int n) {
//        return dp(n);
        return dfs(n, (int)Math.sqrt(n), 1);
    }

    /**
     * @param rest - 剩余的数
     * @param max - 可选的最大的数
     * @param cur - 当前的数
     * @return
     */
    private int dfs(int rest, int max, int cur){
        //刚好用数凑齐了，结束
        if(rest == 0){
            //因为刚好凑齐了，所以用到的平方数为0
            return 0;
        }
        if(cur <= max && rest > 0){
            int counts = rest / (cur * cur);
            int minValue = Integer.MAX_VALUE;
            //能用多少个平方数，逐个尝试dfs
            for(int i = 0; i <= counts; i++){
                //可以使用这个数
                if(rest - (i * cur * cur) >= 0){
                    int res = dfs(rest - (i * cur * cur), max, cur + 1);
                    //如果返回-1，表示凑不齐或者凑多了，反正不是刚刚凑好，这种情况不会理会
                    if(res != -1){
                        minValue = Math.min(minValue, res + i);
                    }
                }
            }
            return (minValue == Integer.MAX_VALUE) ? -1 : minValue;
        }
        return -1;
    }

    private int dp(int n){
        int[] dp = new int[n + 1];
        int max = (int)Math.sqrt(n);
        //base case
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= max; j++){
                if(i - j * j >= 0){
                    min = Math.min(min, dp[i - j * j] + 1);
                }
            }
            dp[i] = Math.min(dp[i], min);
        }
        return dp[n] > n ? -1 : dp[n];
    }

    @Test
    public void test(){
        NumSquares numSquares = new NumSquares();
        int i = numSquares.numSquares(13);
        log.info("i={}", i);
    }
}
