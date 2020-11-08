package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/11/6.
 * leetcode 78. 子集
 * 回溯经典
 */
@Slf4j
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> tempList, List<List<Integer>> res){
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            //做出选择
            tempList.add(nums[i]);
            //递归
            backtrack(nums, i + 1, tempList, res);
            //撤销选择
            tempList.remove(tempList.size() - 1);
        }
    }

    @Test
    public void test(){
        Subsets subsets = new Subsets();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets1 = subsets.subsets(nums);
        log.info("subsets1={}", subsets1);
    }

}
