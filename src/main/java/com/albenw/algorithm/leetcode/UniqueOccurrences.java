package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alben.wong
 * @since 2020/11/14.
 * leetcode 1207. 独一无二的出现次数
 * 用桶计数，然后再用hashmap
 */
@Slf4j
public class UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            Integer orDefault = map.getOrDefault(arr[i], 0);
            map.put(arr[i], orDefault + 1);
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for(Integer count : map.values()){
                Integer orDefault = countMap.getOrDefault(count, 0);
            if(orDefault >= 1){
                return false;
            }
            countMap.put(count, orDefault + 1);
        }
        return true;
    }

    @Test
    public void test(){
        UniqueOccurrences uniqueOccurrences = new UniqueOccurrences();
        int[] nums = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        boolean b = uniqueOccurrences.uniqueOccurrences(nums);
        log.info("b={}", b);
    }

}
