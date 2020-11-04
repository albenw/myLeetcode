package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author alben.wong
 * @since 2020/11/3.
 * leetcode 347. 前 K 个高频元素
 * 用hashmap统计次数，再根据次数排序取出前k个
 * 这个不需要用到
 */
@Slf4j
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0 || k == 0){
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Ele> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Ele ele = new Ele(entry.getKey(), entry.getValue());
            list.add(ele);
        }
        Collections.sort(list, new Comparator<Ele>() {
            @Override
            public int compare(Ele o1, Ele o2) {
                return o2.getFrequent() - o1.getFrequent();
            }
        });
        List<Ele> eles = list.subList(0, k);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = eles.get(i).getValue();
        }
        return res;
    }

    static class Ele {
        private Integer value;
        private Integer frequent;
        public Ele(Integer value, Integer frequent){
            this.value = value;
            this.frequent = frequent;
        }
        public Integer getValue(){
            return this.value;
        }
        public Integer getFrequent(){
            return this.frequent;
        }
    }

    @Test
    public void test(){
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] nums = new int[]{1,1,1,2,2,3,4,4,5,5,5,5,5,5};
        int[] ints = topKFrequent.topKFrequent(nums, 2);
        log.info("ints={}", ints);
    }

}
