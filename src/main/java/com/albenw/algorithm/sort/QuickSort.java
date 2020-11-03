package com.albenw.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/13.
 */
@Slf4j
public class QuickSort {

    public void quickSort(int[] a){
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = partition2(a, left, right);
        quickSort(a, left, pivot);
        quickSort(a, pivot + 1, right);
    }

    /**
     * 快速排序的关键函数: 将区间内的数分成两边，左边比pivot小，右边比pivot大
     *
     * 将大于 pivot 的元素都拷贝到临时数组 Y，最后再将数组 X 和数组 Y 中数据顺序拷贝回去
     * @param a
     */
    private int partition(int[] a, int left, int right){
        //取最后一个最为pivot
        int pivotValue = a[right];
        int[] tempA = new int[right - left];
        int tempACount = 0;
        int[] tempB = new int[right - left];
        int tempBCount = 0;
        for(int i = left; i < right; i++){
            if(a[i] < pivotValue){
                tempA[tempACount] = a[i];
                tempACount++;
            }else{
                tempB[tempBCount] = a[i];
                tempBCount++;
            }
        }
        for(int i = 0; i < tempACount; i++){
            a[left + i] = tempA[i];
        }
        a[left + tempACount] = pivotValue;
        for(int i = 0; i < tempBCount; i++){
            a[left + tempACount + 1 + i] = tempB[i];
        }
        //这里注意要-1
        return left + tempACount - 1;
    }

    /**
     * 这个方法基于交换，不好理解
     * @param arr
     * @param low
     * @param high
     */
    private int partition2(int[] arr, int low, int high){
        int pivot = arr[low];     //枢轴记录
        while (low < high){
            while (low < high && arr[high] >= pivot){
                --high;
            }
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }

    @Test
    public void test1(){
        QuickSort quicksort = new QuickSort();
        int[] a = new int[]{1, 3, 7, 4, 8, 0, 9, 6, 2, 5};
        quicksort.quickSort(a);
        log.info("a={}", a);
    }

}
