package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/12/10.
 * leetcode 66. 加一
 *
 * 对新手来说，不错的一道题
 */
@Slf4j
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return digits;
        }
        return plus(digits, digits.length - 1);
    }

    private int[] plus(int[] digits, int index){
        //最左位补1
        if(index == -1){
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            return res;
        }else{
            if(digits[index] + 1 >= 10){
                digits[index] = 0;
                return plus(digits, index - 1);
            }else{
                digits[index] = digits[index] + 1;
            }
            return digits;
        }
    }

    @Test
    public void test(){
        PlusOne plusOne = new PlusOne();
        int[] nums = new int[]{9};
        int[] ints = plusOne.plusOne(nums);
        log.info("nums={}", ints);
    }
}
