package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alben.wong
 * @since 2020/12/8.
 * leetcode 13. 罗马数字转整数
 */
@Slf4j
public class RomanToInt {

    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        if(s == null || s.length() == 0){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i + 1 <= s.length() - 1){
                char next = s.charAt(i + 1);
                if((c == 'I' && (next == 'V' || next == 'X')) || (c == 'X' && (next == 'L' || next =='C'))
                        || (c == 'C' && (next == 'D' || next == 'M'))){
                    int value = map.get(next) - map.get(c);
                    res = res + value;
                    i++;
                    continue;
                }
            }
            res = res + map.get(c);
        }
        return res;
    }

    @Test
    public void test(){
        RomanToInt romanToInt = new RomanToInt();
        int iv = romanToInt.romanToInt("MCMXCIV");
        log.info("res={}", iv);
    }

}
