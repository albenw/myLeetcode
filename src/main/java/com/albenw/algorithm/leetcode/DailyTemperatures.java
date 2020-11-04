package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Stack;

/**
 * @author alben.wong
 * @since 2020/11/4.
 * leetcode 739. 每日温度
 * 第一想法是先排序再取第一个大于当前值的下标相减，不过这个的复杂度是 O(NlogN * logN)了
 * 用栈的话O(N)就可以了，厉害：具体是小于的栈顶的元素则压栈，否则取出来把两者的下标差写到栈顶元素的下标去
 */
@Slf4j
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < T.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            Integer peek = stack.peek();
            //比较
            while (T[i] > T[peek]){
                res[peek] = i - peek;
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                peek = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    @Test
    public void test(){
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] nums = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures.dailyTemperatures(nums);
        log.info("ints={}", ints);
    }

}
