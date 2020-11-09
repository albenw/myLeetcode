package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.swing.plaf.SpinnerUI;

/**
 * @author alben.wong
 * @since 2020/11/9.
 * leetcode 238. 除自身以外数组的乘积
 * 用暴力O(n*n)肯定没问题，不过题目要求O(n)
 * 由于只能遍历"一次"，这里肯定需要技巧，可能是需要保存/复用一些值
 *
 * 初步想法是从做开始遍历一次得到dpLeft[i]表示从 0 到 i - 1的乘积，从右开始遍历得到dpRight[i]表示从i到n-1的乘积
 * 那么dp[i] = dpLeft[i] * dpRight[i]
 * （一次过，不过内存消耗有点大）
 */
@Slf4j
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] dpLeft = new int[nums.length];
        int[] dpRight = new int[nums.length];
        dpLeft[0] = 1;
        for(int i = 1; i < nums.length;i++){
            dpLeft[i] = dpLeft[i - 1] * nums[i - 1];
        }
        dpRight[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            dpRight[i] = dpRight[i + 1] * nums[i + 1];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = dpLeft[i] * dpRight[i];
        }
        return res;
    }

    @Test
    public void test(){
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] nums = new int[]{1,2,3,4};
        int[] ints = productExceptSelf.productExceptSelf(nums);
        log.info("ints={}", ints);
    }

}
