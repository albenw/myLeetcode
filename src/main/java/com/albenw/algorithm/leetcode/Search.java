package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/4.
 * leetcode 33. 搜索旋转排序数组
 * 如果直接O(N)的话，这题就没意思了，所以肯定使用比O(N)快的算法
 * 自然想到了二分法，这题的特点是数组中分开了两段连续，所以注意处理一下反转点位置就好？？
 */
@Slf4j
public class Search {

    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //判断mid落在哪一边
            //然后根据target跟mid和两端作对比
            if(nums[mid] >= nums[0]){
                if(target >= nums[0] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[nums.length - 1]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        Search search = new Search();
        int[] nums = new int[]{8, 9, 3,4,5,6,7};
        int search1 = search.search(nums, 9);
        log.info("search1={}", search1);
    }

}
