package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @author alben.wong
 * @since 2020/10/22.
 * leetcode 215. 数组中的第K个最大元素
 * 1、维护大小为k的最大堆，pop出k-1个元素后，堆顶就是结果。可以直接用java的PriorityQueue，或者手写一个 (O(N*logN))
 * 2、排好序后的n-k (O(N*logN))
 * 3、快排 (O(N))
 */
@Slf4j
public class FindKthLargest {

    private Random random = new Random();
    /**
     * 这里使用快排:
     * 根据快排的思想，找到pivot后，左边的比pivot小，右边的比pivot大，那pivot不正正符合第k大的元素吗
     * trick是如果pivot比k小，则递归右边，反之
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        int find = quickSort(nums, 0, nums.length - 1, nums.length - k);
        return nums[find];
    }

    private int quickSort(int[] nums, int left, int right, int findIndex){
        int pivotIndex = partition(nums, left, right);
        if(left >= right){
            return left;
        }
        if(pivotIndex == findIndex) {
            return pivotIndex;
        }
        if(pivotIndex < findIndex){
            return quickSort(nums, pivotIndex + 1, right, findIndex);
        }else{
            return quickSort(nums, left, pivotIndex - 1 , findIndex);
        }
    }

    private int partition(int[] nums, int left, int right){
        //设置基准等于left
        //要记录pivot的值
        int pivot = nums[left];
        while (left < right){
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    @Test
    public void test(){
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int kthLargest = findKthLargest.findKthLargest(nums, 4);
        log.info("kthLargest={}", kthLargest);
    }

}
