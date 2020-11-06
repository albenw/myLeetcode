package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/5.
 * leetcode 34. 在排序数组中查找元素的第一个和最后一个位置
 */
@Slf4j
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int first = binarySearchV1(nums, target, 0, nums.length - 1);
        int last = binarySearchV2(nums, target, 0, nums.length - 1);
        return new int[]{first, last};
    }

    /**
     * 查找第一个值等于给定值的元素
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public int binarySearchV1(int[] nums, int target, int left, int right){
        while (left <= right){
            int mid = (left + right) / 2;
            //mid大于和小于的情况
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                //当找到有一个相等的值
                //当是第一个 或者 前一个数不等于target（即还不是第一个等值的数）
                if(mid == 0 || nums[mid - 1] != target){
                    return mid;
                }else{
                    //否则继续往前找
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public int binarySearchV2(int[] nums, int target, int left, int right){
        while (left <= right){
            int mid = (left + right) / 2;
            //mid大于和小于的情况
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                //当找到有一个相等的值
                //当是最后一个 或者 后一个数不等于target
                if(mid == nums.length - 1 || nums[mid + 1] != target){
                    return mid;
                }else{
                    //否则继续往后找
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        SearchRange searchRange = new SearchRange();
        int[] nums1 = new int[]{5, 7, 7, 8, 8, 10};
        int[] ints = searchRange.searchRange(nums1, 8);
        log.info("ints={}", ints);
    }
}
