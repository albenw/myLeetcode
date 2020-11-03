package com.albenw.algorithm.sort;

import com.albenw.algorithm.utils.ArrayUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author alben.wong
 * @date 2018/10/4.
 * 堆排序分两步，1、是建堆，2、是从堆输出
 */
@Slf4j
public class HeapSort {

    public static void main(String[] args) {
        int[] array = { 1, 3, 2, 6, 4, 5, 7};
        log.info("Before heap:{}", Arrays.toString(array));
        heapSort(array);
        log.info("After heap sort:{}", Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        //建堆
        buildMaxHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            //这里的trick是利用原有的数组，把堆顶的元素放到最后，最后数组就是排序了的
            ArrayUtils.exchangeElements(array, 0, i);
            //由于交换数组破坏了最大堆，所有需要进行调整
            maxHeap(array, i, 0);
        }
    }

    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int half = array.length / 2;
        //从最后一个开始
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    private static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            ArrayUtils.exchangeElements(array, index, largest);
            maxHeap(array, heapSize, largest);
        }
    }
}
