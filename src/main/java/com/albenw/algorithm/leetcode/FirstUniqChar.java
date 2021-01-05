package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2021/1/5.
 * leetcode 387. 字符串中的第一个唯一字符
 */
@Slf4j
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        int[] bucket = new int[26];
        for(int i = 0; i < s.length(); i++){
            bucket[s.charAt(i) - 'a'] = bucket[s.charAt(i) - 'a'] + 1;
        }
        for(int i = 0; i < s.length(); i++){
            if(bucket[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        int i = firstUniqChar.firstUniqChar("leetcode");
        log.info("i={}", i);
    }

}
