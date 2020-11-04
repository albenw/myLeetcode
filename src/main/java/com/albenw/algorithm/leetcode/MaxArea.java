package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/4.
 * leetcode 11. 盛最多水的容器
 * 这题用双指针，分别从前后往中间靠近，靠近时往柱子短的那边靠(这个方法不是一下子可以想出来..需要证明)
 *
 */
@Slf4j
public class MaxArea {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            int tmp = (right - left) * Math.min(height[left], height[right]);
            if(tmp > max){
                max = tmp;
            }
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }

    @Test
    public void test(){
        MaxArea maxArea = new MaxArea();
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int i = maxArea.maxArea(nums);
        log.info("i={}", i);
    }
}
