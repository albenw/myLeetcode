package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/12.
 * leetcode 231 - 是否2的次幂
 */
@Slf4j
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    @Test
    public void test1(){
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        boolean powerOfTwo1 = powerOfTwo.isPowerOfTwo(-16);
        log.info("powerOfTwo1={}", powerOfTwo1);
    }

}
