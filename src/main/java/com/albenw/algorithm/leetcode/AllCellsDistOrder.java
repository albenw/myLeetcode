package com.albenw.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author alben.wong
 * @since 2020/11/17.
 * leetcode 1030. 距离顺序排列矩阵单元格
 *
 */
public class AllCellsDistOrder {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] matrix = new int[R * C][2];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                matrix[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(matrix, (o1, o2) -> (Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0))
                - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0)));
        return matrix;
    }

}
