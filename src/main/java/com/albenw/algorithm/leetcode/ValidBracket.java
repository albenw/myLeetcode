package com.albenw.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author alben.wong
 * @since 2020/10/19.
 * leetcode 20. 有效的括号
 */
public class ValidBracket {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 == 1){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.size() > 0){
                    Character pop = stack.pop();
                    if((pop == '(' && c != ')') || (pop == '[' && c != ']') || (pop == '{' && c != '}')){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.size() > 0){
            return false;
        }
        return true;
    }

    @Test
    public void test1(){
        ValidBracket validBracket = new ValidBracket();
        boolean valid = validBracket.isValid("))");
        assert !valid;
    }

}
