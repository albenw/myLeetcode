package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/12/9.
 * leetcode 38. 外观数列
 *
 * 由于需要知道前一项是什么，而前一项有需要知道再前一项，所以很自然的想到了递归
 * 获取到统计字符串：用双指针
 */
@Slf4j
public class CountAndSay {

    public String countAndSay(int n) {
        if(n <= 0){
            return "";
        }
        if(n == 1){
            return "1";
        }
        String last = countAndSay(n - 1);
        int cur = 0;
        int next = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < last.length(); i++){
            char c = last.charAt(i);
            next++;
            if(next >= last.length() || last.charAt(next) != c){
                sb.append(next - cur).append(c);
                cur = next;
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        CountAndSay countAndSay = new CountAndSay();
        String s = countAndSay.countAndSay(7);
        log.info("s={}", s);
        assert s.equals("13112221");
    }

}
