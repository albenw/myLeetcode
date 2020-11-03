package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/2.
 * leetcode 64. 最小路径和
 * 定义dp[i][j]为最小和
 * 那么dp[i][j] = min(dp[i][j - 1], dp[i - 1][j])
 */
@Slf4j
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if(i == 0){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    @Test
    public void test(){
        MinPathSum minPathSum = new MinPathSum();
        int[][] nums = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int i = minPathSum.minPathSum(nums);
        log.info("i={}", i);
    }

}
