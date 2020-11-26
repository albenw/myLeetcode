package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author alben.wong
 * @since 2020/11/23.
 * leetcode 452. 用最少数量的箭引爆气球
 * 初步想法是按照起点排序，然后逐两两找出交叉的区间，记录下来，最后不同的交叉区间就是结果
 *
 * 按照右边界排序，然后从第一个气球右边界的位置开始（作为第一支箭），如果下一个气球的左边界小于箭的位置，则说明该气球可以被该箭穿透
 * 否则不能，那么箭的位置变为该气球的右边界
 *
 * 这题思路有点想贪心
 */
@Slf4j
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if(points.length <= 1){
            return points.length;
        }
        //按照每个气球的右边界排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        //获取排序后第一个气球右边界的位置，我们可以认为是箭射入的位置
        int last = points[0][1];
        //统计箭的数量
        int count = 1;
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > last){
                count++;
                last = points[i][1];
            }
        }
        return count;
    }

    @Test
    public void test(){
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        int[][] nums = new int[][]{
                {1,2},{3,4},{5,6},{7,8}
        };
        int minArrowShots = findMinArrowShots.findMinArrowShots(nums);
        log.info("minArrowShots={}", minArrowShots);
    }

}
