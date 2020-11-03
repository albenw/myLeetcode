package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/29.
 * leetcode 198. 打家劫舍
 * 定义dp[i]为最大金额
 * dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
 */
@Slf4j
public class Rob {

    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    @Test
    public void test(){
        Rob rob = new Rob();
        int[] nums = new int[]{2,7,9,3,1};
        int rob1 = rob.rob(nums);
        log.info("i={}", rob1);
    }
}
