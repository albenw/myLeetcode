package com.albenw.algorithm.leetcode;

import com.albenw.algorithm.utils.ArrayUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author alben.wong
 * @since 2020/12/9.
 * leetcode 31. 下一个排列
 *
 * 首先题目比较难理解，它的意思是找到下一个所有的排列（给定数字）中大于给定数最小的那个
 * 整体思路：假设i之后的数字为降序，那么此时[i, end]是最大的（i为头不能动，无论什么组合），
 * 那么这时只需要在[i + 1, end]中找出最小的数与a[i]交换，
 * 而且保证交换后的[i + 1, end]为升序，那么此时的[i + 1, end]就是比原来大，而为最小的数。
 *
 * 具体思路：
 * 1、从右往左，找到第一个 a[i] < a[i + 1]，这是 [i + 1, end]肯定为降序。这步是为了找到"小数"
 * 2、从右到左，从[i + 1, end]找到第一个比a[i]大的数，交换它们
 * 3、因为此时[i + 1, end]为降序，反转它们，变成升序
 *
 */
@Slf4j
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        //p指向a[i]
        int p = -1;
        //找到第一个a[i] < a[i + 1]
        for(int i = nums.length - 1; i >= 0; i--){
            if(i > 0 && nums[i - 1] < nums[i]){
                p = i - 1;
                break;
            }
        }
        //说明整体为升序
        if(p == -1){
            reverse(nums, 0, nums.length - 1);
        }else{
            int pivot = nums[p];
            //从右到左，找到第一个比pivot大的，然后交换
            for(int i = nums.length - 1; i >= p + 1; i--){
                if(nums[i] > pivot){
                    exchangeElements(nums, p, i);
                    break;
                }
            }
            reverse(nums, p + 1, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int start, int end){
        while (start < end){
            exchangeElements(nums, start, end);
            start++;
            end--;
        }
    }

    public void exchangeElements(int[] array, int index1, int index2){
        int tempI1 = array[index1];
        array[index1] = array[index2];
        array[index2] = tempI1;
    }

    @Test
    public void test(){
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{4,5,2,6,3,1};
        nextPermutation.nextPermutation(nums);
        log.info("res={}", nums);
    }

}
