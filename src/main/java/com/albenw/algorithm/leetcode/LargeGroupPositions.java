package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2021/1/5.
 * leetcode 830. 较大分组的位置
 */
@Slf4j
public class LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String s) {
        if(s == null || s.length() == 0){
            return new LinkedList<>();
        }
        int left = 0;
        int count = 0;
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < s.length() + 1; i++){
            if(i != s.length() && s.charAt(left) == s.charAt(i)){
                count++;
            }else{
                if(count >= 3){
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(left);
                    tmp.add(left + count - 1);
                    res.add(tmp);
                }
                count = 1;
                left = i;
            }
        }
        return res;
    }

    @Test
    public void test(){
        LargeGroupPositions largeGroupPositions = new LargeGroupPositions();
        List<List<Integer>> res = largeGroupPositions.largeGroupPositions("aaa");
        log.info("res={}", res);
    }

}
