package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 *  @author alben.wong
 *  @since 2020/10/22.
 *
 */
@Slf4j
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    @Test
    public void test(){
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates.removeDuplicates(nums);
        log.info("i={}", i);
    }
}
