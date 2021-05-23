package com.albenw.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/13.
 * 自底而上
 */
@Slf4j
public class MergeSort {

    public void mergeSort(int[] a){
        merge(a, 0, a.length - 1);
    }

    private void merge(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        //递归处理两边的数据
        int mid = (left + right) / 2;
        merge(a, left, mid);
        merge(a, mid + 1, right);
        //合并数据
        combine(a, left, mid, right);
    }

    /**
     * 将两边的数据合并到一起
     * 两边的数据已经排好序，从第一个开始对比就可以了
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    private void combine(int[] a, int left, int mid, int right){
        int[] tmp = new int[a.length];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right){
            if(a[i] <= a[j]){
                tmp[k] = a[i];
                k++;
                i++;
            }else{
                tmp[k] = a[j];
                k++;
                j++;
            }
        }
        //多出来的数据
        while(i <= mid){
            tmp[k] = a[i];
            k++;
            i++;
        }
        while (j <= right){
            tmp[k] = a[j];
            k++;
            j++;
        }
        //修改原数组的值
        for(int l = 0; l < k; l++){
            a[left + l] = tmp[l];
        }
    }

    @Test
    public void test1(){
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{1, 3, 7, 4, 8, 0, 6, 2, 5};
        mergeSort.mergeSort(a);
        log.info("a={}", a);
    }

}
