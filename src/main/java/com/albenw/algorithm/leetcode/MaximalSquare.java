package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/29.
 * leetcode 221. 最大正方形
 * 这题跟 1277 countSquares 解法一样
 * 定义dp[i][j]为最大正方形的边长
 */
@Slf4j
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //初始化
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                }else if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }

    @Test
    public void test(){
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int i = maximalSquare.maximalSquare(matrix);
        log.info("i={}", i);
    }
}
