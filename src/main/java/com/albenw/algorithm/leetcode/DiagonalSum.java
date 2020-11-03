package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/25.
 * leetcode 1572. 矩阵对角线元素的和
 */
@Slf4j
public class DiagonalSum {

    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += mat[i][i];
        }
        for(int i = 0; i < n; i++){
            sum += mat[i][n - i - 1];
        }
        if(n % 2 == 1){
            sum -= mat[n / 2][n / 2];
        }
        return sum;
    }

    @Test
    public void test(){
        int[][] mat = new int[][]{
                {1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}
        };
        DiagonalSum diagonalSum = new DiagonalSum();
        int i = diagonalSum.diagonalSum(mat);
        log.info("i={}", i);
    }
}
