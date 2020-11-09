package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/9.
 * leetcode 62. 不同路径
 * 这题比较经典了
 * 应该可以用回溯和dp来做，自己都尝试写一下吧
 *
 */
@Slf4j
public class UniquePaths {

    private int backtrackCount = 0;

    public int uniquePaths(int m, int n) {
//        backtrack(m, n, 0, 0 );
        return dp(m , n);
//        return backtrackCount;
    }

    /**
     * dp方法
     * 定义dp[i][j]为到达位置(i,j)的总共路径，那么dp[i][j] = dp[i - 1][j] + dp[i][j  -1]
     * @param m
     * @param n
     * @return
     */
    private int dp(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 回溯
     * 回溯会超时...
     * @param m
     * @param n
     * @return
     */
    private void backtrack(int m, int n, int i, int j){
        //越界了，不用理会
        if(i >= m || j >= n){
            return;
        }
        //刚好走到"右下角"，计数加1
        if(i == m - 1 && j == n - 1){
            backtrackCount++;
        }
        //向右走一步
        backtrack(m, n, i + 1, j);
        //向下走一步
        backtrack(m, n,  i,j + 1);
    }

    @Test
    public void test(){
        UniquePaths uniquePaths = new UniquePaths();
        int i = uniquePaths.uniquePaths(3, 2);
        log.info("i={}", i);
    }

}
