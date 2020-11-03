package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020-09-02.
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
        if(left > 0){
            generate(subList + "(", result, left - 1, right);
        }
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
