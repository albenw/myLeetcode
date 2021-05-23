package com.albenw.algorithm.test123;

import lombok.extern.slf4j.Slf4j;

/**
 * @author alben.wong
 * @since 2021/5/11.
 * 字节跳动在北京有N个工区，形成一个环状，Bytebus是往返在各个工区的通勤车，按工区的顺序行驶，其中第 i 个工区有汽油 gas[i]升。
 * 你有一辆油箱容量无限的的Bytebus，从第 i 个工区开往第 i+1 个工区需要消耗汽油 cost[i] 升。
 * 你从其中的一个工区出发，开始时油箱为空。如果你可以绕环路行驶一周，则返回出发时工区的编号，否则返回 -1。
 * Gas = [1,2,3,4,5];
 * cost = [3,4,5,1,2];
 */
@Slf4j
public class Bdtest {

    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        int[] result = getResult(gas, cost);
        log.info("result={}", result);
    }

    public static int[] getResult(int[] gas, int[] cost){
        int n = gas.length;
        int[] result = new int[n];
        //尝试从每个工区出发
        for(int i = 0; i < n; i++){
            int gasLeft = 0;
            for(int j = i; j < n + i; j++){
                //加油
                gasLeft += gas[j % n];
                //油耗
                gasLeft -= cost[j % n];
                if(gasLeft < 0){
                    result[i] = -1;
                    break;
                }
            }
            if(gasLeft >= 0){
                result[i] = i;
            }
        }
        return result;
    }

}
