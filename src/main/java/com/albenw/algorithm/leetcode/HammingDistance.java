package com.albenw.algorithm.leetcode;

/**
 * @author alben.wong
 * @since 2020/11/1.
 * leetcdoe 461. 汉明距离
 * 就是判断多少个1: n & (n -1 )
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while(n !=0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
