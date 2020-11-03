package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/30.
 * leetcode 283.移动零
 * 初步想法：双指针（自己尝试后，果然可行）
 * 这题主要考测双指针，如果用暴力的话做不到比较好的时间复杂度，想要O(n)一次遍历完成，很自然就想到了双指针
 * 然后剩下的就是考虑各种变换的情况（智力问题）
 */
@Slf4j
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums.length == 0){
            return;
        }
        int n = nums.length;
        int i = 0;
        int j = 1;
        while (j < n){
            if(nums[i] == 0 && nums[j] == 0){
                j++;
                continue;
            }
            if(nums[i] == 0 && nums[j] != 0){
                swap(nums, i, j);
            }
            i++;
            j++;
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    @Test
    public void test(){
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = new int[]{0,0,1,3,12};
        moveZeroes.moveZeroes(nums);
        log.info("nums={}", nums);
    }

}
