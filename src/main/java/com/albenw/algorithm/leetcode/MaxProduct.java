package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/17.
 * leetcode 152. 乘积最大子数组
 * 这道题跟53不一样，区别在与加法和乘法，乘法不具有"最优子结构"
 * 由于存在负数，需要用一个dpMin来保存最小值
 */
@Slf4j
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            //正数
            if(num >= 0){
                dpMax[i] = Math.max(dpMax[i - 1] * num, num);
                dpMin[i] = Math.min(dpMin[i - 1] * num, num);
            }else{
                //负数
                dpMax[i] = Math.max(dpMin[i - 1] * num, num);
                dpMin[i] = Math.min(dpMax[i - 1] * num, num);
            }
            result = Math.max(dpMax[i], result);
        }
        return result;
    }

    @Test
    public void test1(){
        MaxProduct maxProduct = new MaxProduct();
        int[] nums = new int[]{2,3,-2,4};
        int i = maxProduct.maxProduct(nums);
        log.info("i={}", i);
    }
}
