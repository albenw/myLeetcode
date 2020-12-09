package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alben.wong
 * @since 2020-09-04.
 *
 * 其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
 *
 * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
 *
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
