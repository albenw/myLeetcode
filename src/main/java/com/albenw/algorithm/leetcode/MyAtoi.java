package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/12/9.
 * leetcode 8. 字符串转换整数 (atoi)
 */
@Slf4j
public class MyAtoi {

    public int myAtoi(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int cur = 0;
        int res = 0;
        boolean isNegative = false;
        while (cur < s.length() && s.charAt(cur) == ' '){
            cur++;
        }
        if(cur == s.length()){
            return 0;
        }
        if(s.charAt(cur) == '-'){
            isNegative = true;
            cur++;
        }else if(s.charAt(cur) == '+'){
            cur++;
        }
        while (cur < s.length()){
            if(!Character.isDigit(s.charAt(cur))){
                res *= isNegative ? -1 : 1;
                return res;
            }
            //溢出
            if(res > (Integer.MAX_VALUE - (s.charAt(cur) - '0')) / 10){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + (s.charAt(cur) - '0');
            cur++;
        }
        res *= isNegative ? -1 : 1;
        return res;
    }

    @Test
    public void test(){
        MyAtoi myAtoi = new MyAtoi();
        int res = myAtoi.myAtoi(" -0012a42");
        log.info("res={}", res);
    }

}
