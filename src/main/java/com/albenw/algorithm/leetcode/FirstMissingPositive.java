package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/12/10.
 * leetcode 41. 缺失的第一个正数
 *
 * 这题的难度在于要O(n)和常数级的空间
 * 如果没有上述的条件，那么可以直接用map或者桶来保存所有的数据，然后再遍历一次就可以得到结果
 *
 * 这题的trick在于"正整数"，要降低复杂度，化简为特定的问题解法就需要在这点上思考。
 *
 * 思路：对于长度为n数组，那么"最小正整数"就肯定在[1, n + 1]中
 * 这里还有两个优化：
 * 1、如果用桶的话，那么要n的空间。但是这个可以直接用"标记"来做，把"标记"直接打在原数组上，就不用额外的空间了
 *    遍历数组，把数值对应的下标的数值改为负数，表示改下标已经存在了
 * 2、对负数和大于n + 1的数直接变为n + 1，因为结果最大也就是n + 1
 *
 *
 * 这题有点意思，不过在没有做过类似题目的情况下，有难度
 */
@Slf4j
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        int n = nums.length;
        // init
        for(int i = 0; i < nums.length; i++){
            //小于等于0的数变为n + 1
            if(nums[i] <= 0 || nums[i] > n + 1){
                nums[i] = n + 1;
            }
        }
        //对应下标打上"标记"
        for(int i = 0; i < nums.length; i++){
            //如果是负数说明已经打上"标记"了，要去绝对值
            int value = Math.abs(nums[i]);
            if(value <= nums.length){
                //用绝对值 * -1，确保不会重复打标记，负负得正
                nums[value - 1] = Math.abs(nums[value - 1]) * -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            //没打上"标记"的
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }

    @Test
    public void test(){
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] nums = new int[]{1, 1};
        int i = firstMissingPositive.firstMissingPositive(nums);
        log.info("i={}", i);
    }

}
