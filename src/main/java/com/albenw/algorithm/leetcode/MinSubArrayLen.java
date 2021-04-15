package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2021/4/15.
 * 209. 长度最小的子数组
 *
 * 1、可以用暴力，复杂度是O(n*n)
 * 2、滑动窗口，用两个指针(start和end)维护一个窗口
 * 暴力遍历了所有的情况，其实不需要
 * （1）一直扩大窗口知道大于sum
 * （2）因为这时已经找到一个有效值了，看看能不能找到一个更小的值，所以这时需要start右移
 * （3）判断窗口值是否大于sum，否则end右移
 */
@Slf4j
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < n){
            sum += nums[end];
            //这里的意思是，如果首次找到了，那么继续寻找更优值，即start继续缩小
            //也表示end在当前位置能够找到最优值，所以循环后，end要继续扩大范围寻找
            while(sum >= target){
                result = Math.min(result, end - start + 1);
                //调整sum的值
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    @Test
    public void test(){
        //2,3,1,2,4,3
        //1,1,1,1,1,1,1,1
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int target = 3;
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int i = minSubArrayLen.minSubArrayLen(target, nums);
        log.info("i={}", i);
    }

}
