package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/22.
 * leetcode 72. 编辑距离
 *
 * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * dp[i][j]定义为word1的i个字符和word2的j个字符的最短编辑距离
 *
 */
@Slf4j
public class MinDistance {

    public int minDistance(String word1, String word2) {
        if(word2 == null || word2.length() == 0){
            return word1 == null ? 0 : word1.length();
        }
        if(word1 == null || word1.length() == 0){
            return word2.length();
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= n; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }else{
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test1(){
        MinDistance minDistance = new MinDistance();
        int i = minDistance.minDistance("intention", "execution");
        log.info("i={}", i);
    }

}
