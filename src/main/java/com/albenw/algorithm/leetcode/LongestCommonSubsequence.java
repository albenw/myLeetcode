package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/9/27.
 * leetcode 1143
 *
 * 最长公共子序列
 * 要点：
 * 心中要有dp table；两个字符串遍历的过程
 *
 */
@Slf4j
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0){
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char ca = text1.charAt(i);
                char cb = text2.charAt(j);
                if(ca == cb){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test1(){
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int length = longestCommonSubsequence.longestCommonSubsequence("abc", "edf");
        log.info("length={}", length);
    }

}
