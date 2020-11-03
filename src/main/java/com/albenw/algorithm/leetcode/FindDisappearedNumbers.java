package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/10/30.
 * leetcode 448. 找到所有数组中消失的数字
 * 这题很直接就想到了hashmap来标记已有的数字
 * 但是题目要求不额外使用空间，而且时间复杂度为O(n)，所以肯定是需要用到别的技巧
 * 由于数字可以作为下标，所以很自然想到了桶排序，但是没想到的是要进行标记
 *
 * 这题如果想不到用下标的话，会有点懵
 */
@Slf4j
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        for(int i = 0; i < nums.length; i++){
            int valAsIdx = nums[i];
            if(valAsIdx < 0){
                valAsIdx *= -1;
            }
            if(nums[valAsIdx - 1] > 0){
                nums[valAsIdx - 1] *= -1;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i + 1);
            }
        }
        return list;
    }

    @Test
    public void test(){
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers.findDisappearedNumbers(nums);
        log.info("disappearedNumbers={}", disappearedNumbers);
    }

}
