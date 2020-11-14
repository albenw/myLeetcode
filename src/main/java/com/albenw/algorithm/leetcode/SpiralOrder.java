package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/11/13.
 * leetcode 54. 螺旋矩阵
 * 初步想法，四个方向进行遍历
 * 这题不难，不过可以考验代码能力
 * 下面的代码写得很好理解
 * https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
 */
@Slf4j
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new ArrayList<>();
        }
        int m = matrix[0].length;;
        int n = matrix.length;
        boolean[][] visited = new boolean[n][m];
        List<Integer> res = new ArrayList<>();
        int x = 0;
        int y = 0;
        while(true){
            //向右遍历
            if(visited[y][x]){
                break;
            }
            while(x < m && !visited[y][x]){
                visited[y][x] = true;
                res.add(matrix[y][x++]);
            }
            //向下遍历
            x--;
            y++;
            if(y >= n || visited[y][x]){
                break;
            }
            while(y < n && !visited[y][x]){
                visited[y][x] = true;
                res.add(matrix[y++][x]);
            }
            //向左遍历
            y--;
            x--;
            if(x < 0 || visited[y][x]){
                break;
            }
            while(x >= 0 && !visited[y][x]){
                visited[y][x] = true;
                res.add(matrix[y][x--]);
            }
            //向上遍历
            x++;
            y--;
            if(y < 0 || visited[y][x]){
                break;
            }
            while(y >= 0 && !visited[y][x]){
                visited[y][x] = true;
                res.add(matrix[y--][x]);
            }
            y++;
            x++;
        }
        return res;
    }

    @Test
    public void test(){
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] nums = new int[][]{
                { 1, 2, 3,4},
                { 5, 6,7,8 }
        };
        List<Integer> integers = spiralOrder.spiralOrder(nums);
        log.info("integers={}", integers);
    }

}
