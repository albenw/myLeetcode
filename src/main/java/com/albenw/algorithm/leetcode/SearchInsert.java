package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/18.
 * leetcode 35. 搜索插入位置
 * easy, 用二分搜索找到第一个大于等于的值
 * 如果找不到的话，最后需要注意一下返回0还是length - 1
 */
@Slf4j
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                if(mid < nums.length - 1 && nums[mid + 1] > target){
                    return mid + 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return left >= nums.length - 1 ? left : 0;
    }

    @Test
    public void test(){
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = new int[]{1,3,5,6};
        int i = searchInsert.searchInsert(nums, 0);
        log.info("i={}", i);
    }
}
