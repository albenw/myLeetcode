package com.albenw.algorithm.leetcode;

import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/19.
 * leetcode 300. 最长上升子序列
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //dp[i]定义为以num[i]为结尾的"最长上升子序列"的长度
        int dp[] = new int[nums.length];
        //初始化，默认包含自己问底的长度为1，方便后面找到比他大的加1
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }
        for(int i = 1; i < nums.length; i++){
            //需要在从头遍历，找到所有的可能
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for(int j = 0; j < nums.length; j++){
            res = Math.max(res, dp[j]);
        }
        return res;
    }

    @Test
    public void test(){
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] nums = new int[]{2, 2};
        int i = lengthOfLIS.lengthOfLIS(nums);
        assert i == 4;
    }

}
