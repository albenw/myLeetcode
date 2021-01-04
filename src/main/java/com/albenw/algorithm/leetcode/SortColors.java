package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2021/1/4.
 * leetcode 75. 颜色分类
 *
 * 第一时间想到的是桶排序
 */
@Slf4j
public class SortColors {

    public void sortColors(int[] nums) {
        int colorTypes = 3;
        int[] bucket = new int[colorTypes];
        for(int i : nums){
            bucket[i] = bucket[i] + 1;
        }
        int k = 0;
        for(int i = 0; i < colorTypes; i++){
            int colorNums = bucket[i];
            for(int j = 0; j < colorNums; j++){
                nums[k] = i;
                k++;
            }
        }
    }

    @Test
    public void test(){
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors.sortColors(nums);
        log.info("res={}", nums);
    }
}
