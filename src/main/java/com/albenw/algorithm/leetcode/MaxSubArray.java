package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/9/27.
 * leetcode 53
 */
@Slf4j
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        return dpMethod(nums);
    }

    /**
     * dp方法
     * dp[i]表示以a[i]为尾的最大子序和
     * @param nums
     * @return
     */
    private int dpMethod(int[] nums){
        int[] dp = new int[nums.length];
        int result = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * 最优解
     * 这个方法是优先取正数
     * @param nums
     * @return
     */
    private int solution_1(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int sum = 0;
        int res = nums[0];
        for(int num : nums){
            if(sum > 0){
                sum = sum + num;
            }else{
                sum = num;
            }
            if(sum > res){
                res = sum;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray.maxSubArray(nums);
        log.info("max={}", max);
    }
}
