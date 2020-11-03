package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alben.wong
 * @since 2020-08-26.
 */
@Slf4j
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(target - nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            Integer integer = map.get(nums[i]);
            if(integer != null && integer != i){
                return new int[]{i, integer};
            }
        }
        return new int[]{};
    }

    @Test
    public void test1(){
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{5, 7, 11, 15}, 5);
        log.info("ints={}", ints);
    }
}
