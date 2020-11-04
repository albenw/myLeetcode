package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020-09-02.
 * leetcode 22. 括号生成
 * 由于需要遍历出所有情况，所以需要用到回溯
 */
@Slf4j
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", result, n, n);
        return result;
    }

    private void generate(String subList, List<String> result, int left, int right){
        if(left == 0 && right == 0){
            result.add(subList);
            return;
        }
        //一共有n个左括号和右括号，把它们用完
        if(left > 0){
            generate(subList + "(", result, left - 1, right);
        }
        //注意不能先加右括号
        if(right > left){
            generate(subList + ")", result, left, right - 1);
        }
    }

    @Test
    public void test1() {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);
        log.info("strings={}", strings);
    }

}
