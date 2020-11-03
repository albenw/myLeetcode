package com.albenw.algorithm.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author alben.wong
 * @since 2020-08-23.
 *
 */
public class KthLargest {

    int k = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if(queue.size() < k){
            queue.offer(val);
        }else if(queue.peek() < val){
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    @Test
    public void test1(){

    }
}
