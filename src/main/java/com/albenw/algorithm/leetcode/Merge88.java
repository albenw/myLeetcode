package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author alben.wong
 * @since 2020/11/12.
 * leetcode 88.合并两个有序数组
 * 初步想法是两个指针各指向两个数组，然后做作比，不过nums1需要做后移，这样的话时间复杂度为O(m*n)
 * 第二个想法：将nums2插入后nums1后边，然后做排序，这是O((m+n)logm+n)
 * 第一个想法的优化：比较时不做插入动作，而是做交换动作。如果nums1[i] > nums2[i]，则进行交换（此方法是行不通的，因为交换后会打破正序）
 * 双指针正确的做法是逐个移动，将较小的放到一个地方，这里需要额外的空间
 */
@Slf4j
public class Merge88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ints = Arrays.copyOf(nums1, m);
        int p = 0;
        int q = 0;
        int count = 0;
        while(q < n && p < m){
            if(ints[p] < nums2[q]){
                nums1[count++] = ints[p++];
            }else{
                nums1[count++] = nums2[q++];
            }
        }
        while(q < n){
            nums1[count++] = nums2[q++];
        }
        while(p < m){
            nums1[count++] = ints[p++];
        }
    }

    @Test
    public void test(){
        Merge88 merge88 = new Merge88();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{4, 5, 6};
        merge88.merge(nums1, 3, nums2, 3);
        log.info("nums1={}", nums1);
    }

}
