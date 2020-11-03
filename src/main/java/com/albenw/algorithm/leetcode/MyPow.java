package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020-08-30.
 */
@Slf4j
public class MyPow {

    public double myPow(double x, int n) {
//        if(n == 0){
//            return 1;
//        }
//        if(n < 0){
//            return 1 / myPow(x, -n);
//        }
//        if(n % 2 == 0){
//            return myPow(x * x, n / 2);
//        }else{
//            return x * myPow(x, n - 1);
//        }
        return Math.pow(x, n);

    }

    @Test
    public void test1() {
        MyPow myPow = new MyPow();
        double v = myPow.myPow(2.0, 10);
        log.info("v={}", v);
    }

}
