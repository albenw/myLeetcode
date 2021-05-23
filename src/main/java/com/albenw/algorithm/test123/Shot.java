package com.albenw.algorithm.test123;

import lombok.extern.slf4j.Slf4j;

/**
 * @author alben.wong
 * @since 2021/5/23.
 */
@Slf4j
public class Shot {

    public static void main(String[] args) {
        log.info("test={}", test(10, 90));
    }

    public static int test(int m, int n){
        //dp[i][j] i枪j分的可能性
        int[][] dp = new int[11][101];
        //init
        for(int k = 0; k <= 10; k++){
            dp[1][k] = 1;
        }
        for(int i = 2; i <= 10; i++) {
            for(int j = 0; j <= i * 10; j++){
                for(int k = 0; k <= 10; k++){
                    if(j - k < 0){
                        continue;
                    }
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        return dp[m][n] ;
    }
    
}
