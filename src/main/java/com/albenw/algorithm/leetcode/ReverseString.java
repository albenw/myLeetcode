package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/12.
 * leetcode 344. 反转字符串
 * 双指针
 */
@Slf4j
public class ReverseString {

    public void reverseString(char[] s) {
        if(s.length == 0){
            return;
        }
        for(int p = 0, q = s.length - 1; p < q; p++, q--){
            char tmp = s[p];
            s[p] = s[q];
            s[q] = tmp;
        }
    }

    @Test
    public void test(){
        ReverseString reverseString = new ReverseString();
        char[] chars = "hello".toCharArray();
        reverseString.reverseString(chars);
        log.info("chars={}", chars);
    }

}
