package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author alben.wong
 * @since 2020/11/5.
 * leetcode 56. 合并区间
 * 合并的思路没问题，但是没想到的是要先排序...
 */
@Slf4j
public class Merge {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[][]{};
        }
        //按照左区间排序，这样就可以安心的合并了
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[][] merge = new int[intervals.length][2];
        int index = -1;
        for(int[] inter : intervals){
            if(index == -1){
                index++;
                merge[index] = inter;
            }else{
                //前者的右区间大于等于后者的左区间
                if(merge[index][1] >= inter[1]){
                    //do nothing
                }else if(merge[index][1] >= inter[0]){
                    //直接合并
                    merge[index][1] = inter[1];
                }else{
                    //否者新加一个区间
                    index++;
                    merge[index] = inter;
                }
            }
        }
        //需要复制一个出来，不然可能会有多余的[0][0]出来
        return Arrays.copyOf(merge, index + 1);
    }

    @Test
    public void test() {
        Merge merge = new Merge();
        int[][] nums = new int[][]{
                {1,4},{2,3}
        };
        int[][] merge1 = merge.merge(nums);
        for(int[] x: merge1){
            log.info("x={}" + Arrays.toString(x));
        }
    }

}
