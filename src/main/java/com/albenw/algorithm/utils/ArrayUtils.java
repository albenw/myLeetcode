package com.albenw.algorithm.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author alben.wong
 * @date 2018/10/4.
 */
@Slf4j
public class ArrayUtils {

    public static void exchangeElements(int[] array, int index1, int index2){
        int tempI1 = array[index1];
        array[index1] = array[index2];
        array[index2] = tempI1;
    }
}
