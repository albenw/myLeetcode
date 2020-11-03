package com.albenw.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/13.
 */
@Slf4j
public class InsertionSort {

    public void insertionSort(int[] a){
        if(a.length <= 1){
            return;
        }
        for(int i = 1; i < a.length; i++){
            int target = a[i];
            int j = i;
            //比target大的元素往后退
            //有点像冒泡那样，一直往前"冒"
            while(j > 0 && target <= a[j - 1]){
                a[j] = a[j - 1];
                j--;
            }
            //插进去
            a[j] = target;
        }
    }

    @Test
    public void test1(){
        InsertionSort insertionSort = new InsertionSort();
        int[] a = new int[]{1, 3, 7, 4, 8, 0, 6, 2, 5};
        insertionSort.insertionSort(a);
        log.info("a={}", a);
    }

}
