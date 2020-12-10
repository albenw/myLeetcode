package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author alben.wong
 * @since 2020/12/9.
 * leetcode 48. 旋转图像
 *
 * 对左上角的小矩阵中的每个点，以及这个点对应的"矩阵对称点"进行"顺时针"移动
 * 注意这个"小矩阵"的范围为 i 为 (n + 1) / 2, j 为 n / 2
 *
 * 注意i和j的表示的意思
 * 一共就4种转换，所以顺序并不重要
 *
 * 这题需要注意、留心观察得出规律，之后再慢慢写出代码，最后测试一下
 */
@Slf4j
public class Rotate {

    public void rotate(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        int n = matrix.length;
        for(int i = 0; i < (n + 1) / 2; i++){
            for(int j = 0; j < n / 2; j++){
                int tmp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    @Test
    public void test(){
        Rotate rotate = new Rotate();
        int[][] nums = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        rotate.rotate(nums);
        log.info("res={}", Arrays.deepToString(nums));
    }

}
