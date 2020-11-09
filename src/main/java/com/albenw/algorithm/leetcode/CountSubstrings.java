package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/9.
 * leetcode 647. 回文子串
 * 两种解法：
 * dp：跟"最长回文子串"类似
 * 中心点法：（这有点难理解）
 */
@Slf4j
public class CountSubstrings {

    public int countSubstrings(String s) {
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        //初始化
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
            res++;
        }
        for(int i = 1; i < s.length(); i++){
            for(int j = 0; j < i; j++){
                if(i - j > 2){
                    dp[j][i] = dp[j + 1][i - 1] && s.charAt(j) == s.charAt(i);
                }else{
                    dp[j][i] = s.charAt(j) == s.charAt(i);
                }
                if(dp[j][i]){
                    res++;
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        CountSubstrings countSubstrings = new CountSubstrings();
        int abc = countSubstrings.countSubstrings("abc");
        log.info("abc={}", abc);
    }
}
