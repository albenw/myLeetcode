package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/8.
 * leetcode 240. 搜索二维矩阵 II
 * 初步想法是用二分在第一行找，如果找到最好，如果找不到则找第一个大于target的值，然后在前一列再用二分找
 *
 * 此题有个更巧妙的方法，就是从左下角开始找，比target大则往友走，小则往上走，直到找到或走到尽头
 */
@Slf4j
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        return binarySearch(matrix, target);
    }

    private boolean binarySearch(int[][] matrix, int target){
        int[] firstLine = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++){
            firstLine[i] = matrix[0][i];
        }
        //在第一行找不到
        int find = binarySearchV0(firstLine, target, 0, firstLine.length - 1);
        if(find >= 0){
            return true;
        }
        int firstLarger = binarySearchFirstLarger(firstLine, target, 0, firstLine.length - 1);
        for(int i = 0; i <= firstLarger; i++){
            int[] suspectColumn = new int[matrix.length];
            for(int j = 0;j < matrix.length; j++){
                suspectColumn[j] = matrix[j][i];
            }
            int i1 = binarySearchV0(suspectColumn, target, 0, suspectColumn.length - 1);
            if(i1 >= 0){
                return true;
            }
        }
        return false;
    }

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

    public int binarySearchFirstLarger(int[] nums, int target, int left, int right){
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] > target && (mid == 0 || nums[mid - 1] < target)){
                    return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(left >= nums.length - 1){
            return nums.length - 1;
        }
        return -1;
    }

    @Test
    public void test(){
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] nums = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean b = searchMatrix.searchMatrix(nums, 5);
        log.info("b={}", b);
    }

    @Test
    public void binarySearchFirstLargerTest(){
        SearchMatrix searchMatrix = new SearchMatrix();
        int[] nums = new int[]{1,   4,  7, 11, 15};
        int i = searchMatrix.binarySearchFirstLarger(nums, 16, 0, nums.length - 1);
        log.info("i={}", i);
    }

}
