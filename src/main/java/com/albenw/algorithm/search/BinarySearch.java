package com.albenw.algorithm.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/14.
 * 二分查找有四种形式:
 * 查找第一个值等于给定值的元素
 * 查找最后一个值等于给定值的元素
 * 查找第一个大于等于给定值的元素
 * 查找最后一个小于等于给定值的元素
 *
 * 本质是：在找到等值的数的时候再做一些判断是否符合"第一个"、"最后一个"，否则继续查找
 */
@Slf4j
public class BinarySearch {

    /**
     * 普通版本
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public int binarySearchV0(int[] nums, int target, int left, int right){
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //mid大于和小于的情况
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
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

    /**
     * 查找第一个大于等于给定值的元素
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public int binarySearchV3(int[] nums, int target, int left, int right){
        while (left <= right){
            int mid = (left + right) / 2;
            //mid大于和小于的情况
            if(nums[mid] > target){
                //前一个数等于target，则当前数实锤了
                if(mid == 0 || nums[mid - 1] == target){
                    return mid;
                }else{
                    right = mid - 1;
                }
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                //等值情况
                if(mid < nums.length - 1 && nums[mid + 1] > target){
                    return mid + 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public int binarySearchV4(int[] nums, int target, int left, int right){
        while (left <= right){
            int mid = (left + right) / 2;
            //mid大于和小于的情况
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                if(mid < nums.length - 1 && nums[mid + 1] == target){
                    return mid;
                }else{
                    left = mid + 1;
                }
            }else{
                //等值情况
                if(mid > 0 && nums[mid - 1] != target){
                    return mid - 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void binarySearchV0Test(){
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int i = binarySearch.binarySearchV0(nums, 7, 0, nums.length - 1);
        log.info("i={}", i);
    }

    @Test
    public void binarySearchV1Test(){
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{1,2,3,4,5,6,7,7,7,7,8,9};
        int i = binarySearch.binarySearchV1(nums, 7, 0, nums.length - 1);
        log.info("i={}", i);
    }

    @Test
    public void binarySearchV2Test(){
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{1,2,3,4,5,6,7,7,7,7,8,9};
        int i = binarySearch.binarySearchV2(nums, 7, 0, nums.length - 1);
        log.info("i={}", i);
    }

    @Test
    public void binarySearchV3Test(){
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int i = binarySearch.binarySearchV3(nums, 1, 0, nums.length - 1);
        log.info("i={}", i);
    }

    @Test
    public void binarySearchV4Test(){
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int i = binarySearch.binarySearchV4(nums, 1, 0, nums.length - 1);
        log.info("i={}", i);
    }

}

