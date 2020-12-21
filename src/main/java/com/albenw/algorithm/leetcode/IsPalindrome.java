package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/12/21.
 * leetcode 125. 验证回文串
 */
@Slf4j
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if(!Character.isDigit(s.charAt(left)) && !Character.isAlphabetic(s.charAt(left))){
                left++;
                continue;
            }
            if(!Character.isDigit(s.charAt(right)) && !Character.isAlphabetic(s.charAt(right))){
                right--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        IsPalindrome isPalindrome = new IsPalindrome();
        //A man, a plan, a canal: Panama
        //race a car
        boolean palindrome = isPalindrome.isPalindrome("A man, a plan, a canal: Panama");
        log.info("palindrome={}", palindrome);
    }

}
