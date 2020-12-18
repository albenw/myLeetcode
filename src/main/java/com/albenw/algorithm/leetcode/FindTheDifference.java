package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/12/18.
 * leetcode 389. 找不同
 *
 * 很简单，虽然t的乱序的，但是只是增加了一个字母
 * 1、遍历一次s，用map每一个字母；遍历t找到没有出现过字母
 * 2、用 sum(ascii(s)) - sum(ascii(t)) 就是多出来的字母
 */
@Slf4j
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
         if(s.length() == 0){
             return t.charAt(0);
         }
         int sum_s = 0;
         int sum_t = 0;
         for(int i = 0; i < s.length(); i++){
             sum_s += (s.charAt(i));
         }
         for(int j = 0; j < t.length(); j++){
             sum_t += (t.charAt(j));
         }
         return (char)(sum_t - sum_s);
    }

    @Test
    public void test(){
        FindTheDifference findTheDifference = new FindTheDifference();
        char theDifference = findTheDifference.findTheDifference("abcd", "abcde");
        log.info("theDifference={}", theDifference);
    }

}
