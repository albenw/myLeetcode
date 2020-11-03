package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/26.
 * leetcode 1277. 统计全为1的正方形子矩阵
 * 这题难在dp的定义
 * dp[i][j]定义为以i,j为右下角的最大正方形的边长（最大边长与正方形个数等价）
 * dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
 * 这个取最小值不好理解
 */
@Slf4j
public class CountSquares {

    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //初始化
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                }
                else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
                //这步有点不好理解。例如dp[i][j]=3，表示分别由边长为1、2、3的正方形各一个，注意这三个正方形的右下角都是dp[i][j]
                //所以这三个正方形都是独立的，不会重复计算，并且在dp[i][j]处一起计算。
                //这题这一步很关键，递推出最大正方形的边长也是为了这一步来方便计算正方形的个数
                res += dp[i][j];
            }
        }
        return res;
    }

    @Test
    public void test(){
        CountSquares countSquares = new CountSquares();
        int[][] matrix = new int[][]{
                {1,0,1},{1,1,0},{1,1,0}
        };
        int i = countSquares.countSquares(matrix);
        log.info("i={}", i);
    }

}
