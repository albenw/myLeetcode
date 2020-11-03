package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author alben.wong
 * @since 2020-08-23.
 */
@Slf4j
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k <= 0){
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(deque.peekFirst() < (i - k + 1)){
                deque.pollFirst();
            }
            if(i -k + 1 >= 0){
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, 3);
        log.info("ints={}", ints);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{3, 2, 1};
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, 2);
        log.info("ints={}", ints);
    }

}
