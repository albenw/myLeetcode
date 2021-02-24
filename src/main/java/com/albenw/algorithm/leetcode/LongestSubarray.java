package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author alben.wong
 * @since 2021/2/24.
 * leetcode 1438 - 绝对差不超过限制的最长连续子数组
 *
 * 显然，使用滑动窗口，维护当前窗口的的最大值和最小值是解决这个问题的关键。
 * 既然是维护，那就要考虑，当窗口扩大时，那来一个新的值是很容易知道是否是最大值或者是最小值，即维护起来是简单直观的。
 * 但是，当窗口减小时，假如从窗口出去的是最大值，或者是最小值，那么窗口缩小以后的最小值或者最大值是啥呢。所以相对窗口增大再次判断最值不容易想出来。
 * 实际上，这个维护窗口的最值问题，是一个非常经典的问题，归纳出来一种普遍认为比较好用的方法，就是使用单调队列。
 * 因为单调队列保持了队列中元素之间的固有的顺序，同时也维护了单调性。这样，当窗口减小时，我们非常容易知道下一个最值是多少。
 * 但是，单调队列只能维护一种单调性，而题目又要求我们同时考虑最大值和最小值的差，所以就用两个呗，后边的解决方法也就顺其自然了。
 *
 * ------------------------
 * 整个过程：
 * right往右走的同时维护最大值和最小值的队列，然后比较最大值和最小值的差值，如果有大于limit的话，说明当前窗口不符合条件，则缩小窗口继续判断。
 * 当left停下来时，right继续走，直到最后。
 *
 */
@Slf4j
public class LongestSubarray {

    public int longestSubarray(int[] nums, int limit) {
        if(nums.length == 0){
            return 0;
        }
        //保存最大值的queue
        Deque<Integer> maxQue = new LinkedList<>();
        //保存最小值的queue
        Deque<Integer> minQue = new LinkedList<>();
        //滑动窗口左边界
        int left = 0;
        //滑动窗口右边界
        int right = 0;
        //结果
        int res = 0;
        while(right < nums.length){
            //从后面"逼走"最大值队列中比窗口右边界小的值
            while (!maxQue.isEmpty() && maxQue.peekLast() < nums[right]){
                maxQue.pollLast();
            }
            //从后面"逼走"最小值队列中比窗口右边界大的值
            while (!minQue.isEmpty() && minQue.peekLast() > nums[right]){
                minQue.pollLast();
            }
            //为什么是"这样""逼走"队列中的数据？
            //如果当前的right是最值，那么即使前面的数据退出窗口的话，最值是保持不变的。
            //如果不是，则需要写入队列的后面，即当前一个最值退出窗口时，自己就是最值。

            //最值写到队列中的后面
            maxQue.offerLast(nums[right]);
            minQue.offerLast(nums[right]);
            //检查当前窗口中最大值和最小值，如果大于limit，则需要缩小窗口，即左边界往右走
            while (!maxQue.isEmpty() && !minQue.isEmpty() && (maxQue.peekFirst() - minQue.peekFirst() > limit)){
                //如果退出窗口的数据等于最大值或最小值，则也需要把队列中的数据删除
                if(nums[left] == maxQue.peekFirst()){
                    maxQue.pollFirst();
                }
                if(nums[left] == minQue.peekFirst()){
                    minQue.pollFirst();
                }
                left++;
            }
            //保持res最大
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    @Test
    public void test() {
        LongestSubarray longestSubarray = new LongestSubarray();
        int[] nums = new int[]{4,2,2,2,4,4,2,2};
        int limit = 0;
        int i = longestSubarray.longestSubarray(nums, limit);
        log.info("i={}", i);
    }

}
