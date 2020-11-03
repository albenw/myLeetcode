package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/29.
 * leetcode 155.最小栈
 * leetcode的解法，用辅助栈，辅助栈的元素与栈中的元素一一对应，表示到对应栈中元素的最小值，此方法可以做到时间O(1)
 */
@Slf4j
public class MinStack {

    private static int INIT_SIZE = 16;
    private int[] data;
    private int size;
    //指向当前栈顶
    private int index = -1;
    //最小值的下标
    private int minIndex = 0;

    /** initialize your data structure here. */
    public MinStack() {
        data = new int[INIT_SIZE];
        size = INIT_SIZE;
    }

    public void push(int x) {
        ++index;
        //扩容
        if(index >= size - 1){
            int newSize = size * 2;
            int[] newData = new int[newSize];
            System.arraycopy(data, 0, newData, 0, size);
            size = newSize;
            data = newData;
        }
        data[index] = x;
        if(x < data[minIndex]){
            minIndex = index;
        }
    }

    public void pop() {
        if(index == -1){
            return;
        }
        int idx = index;
        index--;
        if(minIndex == idx){
            //找出最小值
            int min = Integer.MAX_VALUE;
            for(int i = 0; i <= index; i++){
                if(data[i] <= min){
                    min = data[i];
                    minIndex = i;
                }
            }
        }
    }

    public int top() {
        return data[index];
    }

    public int getMin() {
        return data[minIndex];
    }

    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.getMin();
        minStack.push(-2147483647);
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
    }
}
