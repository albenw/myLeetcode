package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author alben.wong
 * @since 2020-08-26.
 * leetcode 15. 三数之和
 * 这道题用hash法容易超时
 */
@Slf4j
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length <= 2){
            return new ArrayList<>();
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++){
                Integer key = 0 - nums[i] - nums[j];
                String value = i + "_" + j;
                List<String> strings = map.get(key);
                if(strings == null){
                    List<String> list = new ArrayList<>();
                    list.add(value);
                    map.putIfAbsent(key, list);
                }else{
                    //同样的值是否已存在
                    boolean dupFlag = false;
                    for(String existIndex : strings) {
                        String[] s1 = existIndex.split("_");
                        int ia = Integer.valueOf(s1[0]);
                        int ib = Integer.valueOf(s1[1]);
                        if((nums[ia] == nums[i] && nums[ib] == nums[j])
                                || (nums[ia] == nums[j] && nums[ib] == nums[i])){
                            dupFlag = true;
                            break;
                        }
                    }
                    if(!dupFlag){
                        strings.add(value);
                    }
                }
            }
        }

        List<String> resultStr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            List<String> indexMatches = map.get(nums[i]);
            if(indexMatches == null){
                continue;
            }
            for(String s : indexMatches) {
                String[] s1 = s.split("_");
                int ia = Integer.valueOf(s1[0]);
                int ib = Integer.valueOf(s1[1]);
                int[] sortNums = new int[]{nums[i], nums[ia], nums[ib]};
                Arrays.sort(sortNums);
                String value = sortNums[0] + "_" + sortNums[1] + "_" + sortNums[2];
                if(ia != i && ib != i && !resultStr.contains(value)){
                    resultStr.add(value);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(String str : resultStr){
            String[] split = str.split("_");
            List<Integer> tmp = new ArrayList<>();
            tmp.add(Integer.valueOf(split[0]));
            tmp.add(Integer.valueOf(split[1]));
            tmp.add(Integer.valueOf(split[2]));
            result.add(tmp);
        }
        return result;
    }

    @Test
    public void test1(){
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);
        log.info("lists={}", lists);
    }

}
