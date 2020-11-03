package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alben.wong
 * @since 2020-09-04.
 */
@Slf4j
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> existMap = new HashMap<>();
        int max = 0;
        for(int start = 0, end = 0; end < s.length(); end ++){
            if(existMap.containsKey(s.charAt(end))){
                start = Math.max(existMap.get(s.charAt(end)), start);
            }
            max = Math.max(end - start + 1, max);
            existMap.put(s.charAt(end), end + 1);
        }
        return max;
    }

    @Test
    public void test1(){
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int max = lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb");
        log.info("max={}", max);
    }
}
