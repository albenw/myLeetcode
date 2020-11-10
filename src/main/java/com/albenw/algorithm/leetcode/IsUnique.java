package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/9.
 * 面试题 01.01. 判定字符是否唯一
 *
 * 用hashmap是没问题的，但是题目说"如果你不使用额外的数据结构，会很加分"
 * 如果只在原字符串的基础上做判断的话，怎么也要O(N*N)，即暴力法，也不是一个优解
 * 初步想法是类似桶排序，用下标进行累加（需要额外用到一个辅助数组，算额外的数据结构么？）
 *
 */
@Slf4j
public class IsUnique {

    public boolean isUnique(String astr) {
        //假设只有小写字母
        int[] count = new int[26];
        for(int i = 0; i < astr.length(); i++){
            int index = astr.charAt(i) - 'a';
            count[index] = count[index] + 1;
        }
        for(int j = 0; j < count.length; j++){
            if(count[j] > 1){
                return false;
            }
        }
        return true;
    }

    @Test
    public void tes(){
        IsUnique isUnique = new IsUnique();
        boolean unique = isUnique.isUnique("abc");
        log.info("unique={}", unique);
    }

}
