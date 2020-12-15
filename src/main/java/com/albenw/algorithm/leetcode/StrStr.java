package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/12/14.
 * leetcode 28. 实现 strStr()
 *
 * 这题是考察字符串匹配，暴力的话可以用双指针
 * 优化一下可以用kmp，不过效率并不算特出
 */
@Slf4j
public class StrStr {

    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        if(haystack.length() == 0){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        return kmp(haystack, needle);
    }

    private int kmp(String haystack, String needle){
        int[] next = getNext(needle);
        int j = 0;
        int i = 0;
        while (i < haystack.length() && j < needle.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == needle.length()){
            return i - j;
        }
        return -1;
    }

    private int[] getNext(String pattern){
        int[] next = new int[pattern.length()];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < pattern.length() - 1){
            if(j == -1 || pattern.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                //next[i] = j 是因为模式串的前后缀相等
                next[i] = j;
            }else{
                // 比较到第j个字符，说明p[0~j-1]字符串和p[i-j~i-1]字符串相等，而next[j]表示
                // p[0~j-1]的前缀和后缀的最长共有长度，所接下来可以直接比较p[next[j]]和p[i]
                j = next[j];
            }
        }
        return next;
    }

    @Test
    public void test(){
        StrStr strStr = new StrStr();
        int kmp = strStr.kmp("a", "");
        log.info("kmp={}", kmp);
    }
}
