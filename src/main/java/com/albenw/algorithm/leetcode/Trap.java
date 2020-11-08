package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/6.
 * leetcode 42. 接雨水
 * 想不到的是："对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值"
 * 暴力：通过上述求雨水的方法，那么就可以通过遍历每个位置，然后再分别从左右开始遍历求得左右最大值，就可以得出当前位置的可接水量
 * 优化：不用每次都求左右的最大值，可以利用之前求得已知最大值
 */
@Slf4j
public class Trap {

    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int res = 0;
        //leftMax[i]表示i位置的左边的最大值
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        //rightMax[i]表示i位置右边的最大值
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        //leftMax和rightMax有点像dp
        for(int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for(int j = height.length - 2; j >= 0; j--){
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        for(int k = 0; k < height.length; k++){
            res += Math.min(leftMax[k], rightMax[k]) - height[k];
        }
        return res;
    }

    @Test
    public void test(){
        Trap trap = new Trap();
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap1 = trap.trap(nums);
        log.info("trap1={}", trap1);
    }

}
