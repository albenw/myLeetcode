package com.albenw.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alben.wong
 * @since 2020/11/27.
 * leetcode 454. 四数相加 II
 * 其实很简单。。用一个map存放两组的sum，然后另一个map另外两组的sum，然后寻找
 */
public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0){
            return 0;
        }
        Map<Integer, Integer> firstMap = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int key = A[i] + B[j];
                if(firstMap.containsKey(key)){
                    firstMap.put(key, firstMap.getOrDefault(key, 0) + 1);
                }else{
                    firstMap.put(key, 1);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int key = -(C[i] + D[j]);
                if(firstMap.containsKey(key)){
                    res = res + firstMap.get(key);
                }
            }
        }
        return res;
    }

}
