package com.albenw.algorithm.leetcode;

/**
 * @author alben.wong
 * @since 2020/10/12.
 * leetcode 338 比特位计数
 */
public class CountBits {

    public int[] countBits(int num) {
        int[] nums = new int[num + 1];
        for(int i = 1; i <= num; i++){
            //这个比较巧妙
            nums[i] = nums[i & (i - 1)] + 1;
        }
        return nums;
    }

}
