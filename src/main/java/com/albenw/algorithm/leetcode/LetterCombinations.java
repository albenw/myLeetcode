package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author alben.wong
 * @since 2020/11/5.
 * leetcode 17. 电话号码的字母组合
 * 回溯还是写到不够好，思考的时候思路是对的，但是没写出来，有点乱
 * 这个跟全排列有点类似
 */
@Slf4j
public class LetterCombinations {

    private HashMap<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        dfs(digits, 0, new StringBuffer(), result);
        return result;
    }

    private void dfs(String digits, int curIndex, StringBuffer sb, List<String> result){
        //如果curIndex多1了，说明不用递归下去了
        if(curIndex == digits.length()){
            result.add(sb.toString());
        }else{
            char c = digits.charAt(curIndex);
            String candidates = map.get(c);
            for(int i = 0; i < candidates.length(); i++){
                sb.append(candidates.charAt(i));
                dfs(digits, curIndex + 1, sb, result);
                //这步是关键，删掉的是当前递归层次的那个字母，为什么：因为让同一层次的下一个字母递下去，即for循环的下一个字母
                sb.deleteCharAt(curIndex);
            }
        }
    }

    @Test
    public void test(){
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> result = letterCombinations.letterCombinations("23");
        log.info("result={}", result);
    }

}
