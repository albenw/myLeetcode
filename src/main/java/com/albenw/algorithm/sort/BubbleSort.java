package com.albenw.algorithm.sort;

import com.albenw.algorithm.utils.ArrayUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/13.
 */
@Slf4j
public class BubbleSort {

    public void bubbleSort(int[] a){
        if(a.length <= 1){
            return;
        }
        for(int i = 0; i < a.length; i++){
            boolean flag = false;
            //因为要合j+1做比较，所以要-1
            for(int j = 0; j < a.length - i - 1; j++){
                if(a[j] > a[j + 1]){
                    ArrayUtils.exchangeElements(a, j, j + 1);
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    @Test
    public void test1() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = new int[]{1, 3, 7, 4, 8, 0, 6, 2, 5};
        bubbleSort.bubbleSort(a);
        log.info("a={}", a);
    }

}
