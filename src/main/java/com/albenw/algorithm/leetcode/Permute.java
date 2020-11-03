package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/11/2.
 * leetcode 46. 全排列
 * 考察dfs，自上而下的dfs
 */
@Slf4j
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            Deque<Integer> deque = new ArrayDeque<>();
            deque.addLast(i);
            dfs(nums, res, deque);
        }
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> addedIndex){
        if(addedIndex.size() == nums.length){
            res.add(convert(nums, addedIndex));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            //如果还没添加，则继续尝试
            if(!addedIndex.contains(i)){
                //增加一个试试
                addedIndex.addLast(i);
                //使用当前这个数，将后面的数字递归下去
                dfs(nums, res, addedIndex);
                //还原回去
                addedIndex.removeLast();
            }
        }
    }

    private List<Integer> convert(int[] nums, Deque<Integer> addedIndex){
        List<Integer> values = new ArrayList<>();
        for(Integer value : addedIndex){
            values.add(nums[value]);
        }
        return values;
    }

    @Test
    public void test(){
        Permute permute = new Permute();
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> permute1 = permute.permute(nums);
        log.info("permute1={}", permute1);
    }

}
