package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/20.
 * leetcode 7. 整数反转
 */
@Slf4j
public class ReverseInt {

    public int reverse(int x) {
        long res = 0;
        while(x != 0){
            int tmp = x % 10;
            res = res * 10 + tmp;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return (int)res;
    }

    @Test
    public void test1(){
        ReverseInt reverseInt = new ReverseInt();
        int reverse = reverseInt.reverse(-1534236469);
        log.info("reverse={}", reverse);
    }
}
