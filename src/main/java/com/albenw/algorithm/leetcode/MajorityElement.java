package com.albenw.algorithm.leetcode;

import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020-08-30.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int cur = nums[0];
        for(int i : nums) {
            if(count == 0){
                cur = i;
                count++;
            }else if(cur == i){
                count++;
            }else{
                count--;
            }
        }
        return cur;
    }

    @Test
    public void test1(){

    }

}
