package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2021/5/30.
 * 45. 跳跃游戏 II
 */
@Slf4j
public class Jump {

    public int jump(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        //不用计算到达最后一步
        for(int i = 0; i < nums.length - 1; i++){
            int canJumpIndex = i + nums[i];
            //能搞到达的最远距离
            maxPosition = Math.max(maxPosition, canJumpIndex);
            //在本次能够jump的范围内：更新下一个end；增加一步
            if(i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    @Test
    public void test(){
        Jump jump = new Jump();
        int [] nums = new int[]{2,3,0,1,4};
        int jump1 = jump.jump(nums);
        log.info("jump1={}", jump1);
    }

}
