package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/10/17.
 * leetcode 120. 三角形最小路径和
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * dp[i][j] 表示从点 (i, j)(i,j) 到底边的最小路径和
 * dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
 */
@Slf4j
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    @Test
    public void test1(){
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(5);l3.add(6);l3.add(7);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        MinimumTotal minimumTotal = new MinimumTotal();
        int i = minimumTotal.minimumTotal(lists);
        log.info("i={}", i);
    }

}
