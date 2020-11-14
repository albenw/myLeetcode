package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author alben.wong
 * @since 2020/11/14.
 * leetcode 1122. 数组的相对排序
 * 用hashmap
 */
@Slf4j
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : arr1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : arr2){
            Integer value = map.getOrDefault(num, 0);
            for(int i = 0; i < value; i++){
                list.add(num);
            }
            map.remove(num);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Integer value = entry.getValue();
            for(int i = 0; i < value; i++){
                list.add(entry.getKey());
            }
        }
        int[] res = new int[arr1.length];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void test(){
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] nums1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] nums2 = new int[]{2,1,4,3,9,6};
        int[] ints = relativeSortArray.relativeSortArray(nums1, nums2);
        log.info("ints={}", ints);
    }

}
