package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020-09-04.
 * leetcode 5. 最长回文子串
 * 回文：bab是，baba不是
 */
@Slf4j
public class LongestPalindrome {

    /**
     * 回文具递推性质
     * dp[i][j]定义为 si -> sj 是否回文
     * dp[i][j] = dp[i + 1][j - 1] && (si == sj)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        //初始化
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        //注意循环
        int maxLength = 0;
        int left = 0;
        int right = 0;
        for(int j = 1; j < s.length(); j++){
            for(int i = 0; i < j; i++){
                if(i + 1 <= j - 1){
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                //记录
                if(dp[i][j] && (j - i + 1) > maxLength){
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    @Test
    public void test() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = longestPalindrome.longestPalindrome("bbbcbbb");
        assert s.equals("bbbcbbb");
    }
}
