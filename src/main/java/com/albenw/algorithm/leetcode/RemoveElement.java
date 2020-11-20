package com.albenw.algorithm.leetcode;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author alben.wong
 * @since 2020/11/19.
 * leetcode 27. 移除元素
 * 初步想法用双指针，一个指向数组头，一个指向数组尾，将前面值为val的元素交换到后面
 * 要注意边界，debug几次
 */
@Slf4j
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int count = nums.length;
        int p = 0;
        int q = nums.length - 1;
        while (p <= q){
            while (nums[q] == val && q > 0){
                q--;
                count--;
            }
            if(nums[p] == val && p <= q){
                exchangeElements(nums, p, q);
                p++;
                q--;
                count--;
            }else{
                p++;
            }
        }
        nums = Arrays.copyOf(nums, count);
        return count;
    }

    public void exchangeElements(int[] array, int index1, int index2){
        int tempI1 = array[index1];
        array[index1] = array[index2];
        array[index2] = tempI1;
    }

    @Test
    public void test(){
        RemoveElement removeElement = new RemoveElement();
        int[] nums = new int[]{2};
        int i = removeElement.removeElement(nums, 2);
        log.info("i={}", i);
    }

}
