package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/10.
 * leetcode 69  x 的平方根
 * 考察二分查找
 */
@Slf4j
public class MySqrt {

    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int left = 1;
        int right = x / 2 + 1;
        int res = 0;
        while (left <= right){
            int mid = (left + right) / 2;
            if(mid == x / mid){
                return mid;
            }else if(mid > x / mid){
                right = mid - 1;
            }else{
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        MySqrt mySqrt = new MySqrt();
        int i = mySqrt.mySqrt(8);
        log.info("i={}", i);
    }
}
