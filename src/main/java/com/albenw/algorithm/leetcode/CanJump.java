package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/6.
 * leetcode 55. 跳跃游戏
 * 尝试用dp，定义dp[i]为是否能够跳到这步, 那么 dp[i] = dp[j] && nums[j] > i - j
 * 上述方法需要用到两个for循环
 * 定义dp[i]为跳到这步的最大剩余步数，如果为-1，则表示不能跳到这步，那么dp[i] = max(dp[i - 1], nums[i - 1]) - 1;
 */
@Slf4j
public class CanJump {

    public boolean canJump(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return true;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++){
            if(dp[i - 1] == -1){
                dp[i] = -1;
            }else{
                dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
            }
        }
        return dp[nums.length - 1] >= 0;
    }

    @Test
    public void test(){
        CanJump canJump = new CanJump();
        int[] nums = new int[]{0, 2, 3};
        boolean b = canJump.canJump(nums);
        log.info("b={}", b);
    }

}
