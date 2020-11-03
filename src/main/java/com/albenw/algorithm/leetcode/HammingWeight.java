package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/12.
 * leetcode 191
 * 统计二进制1的个数 - 也被称为汉明重量
 */
@Slf4j
public class HammingWeight {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    @Test
    public void test1(){
        HammingWeight hammingWeight = new HammingWeight();
        int i = hammingWeight.hammingWeight(9);
        log.info("i={}", i);
    }

}
