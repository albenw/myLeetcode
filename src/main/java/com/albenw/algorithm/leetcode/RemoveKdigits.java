package com.albenw.algorithm.leetcode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/15.
 * leetcode 402. 移掉K位数字
 * 首先需要思考的是，如何去掉一个数字让剩余变得最小：如果前面的数字比后一位大，那么就去掉它
 */
@Slf4j
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || k >= num.length()){
            return "0";
        }
        for(int i = 0; i < k; i++){
            boolean flag = false;
            for(int j = 0; j < num.length() - 1; j++){
                if(num.charAt(j) > num.charAt(j + 1)){
                    //去掉第j个
                    num = num.substring(0, j) + num.substring(j + 1);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                //去掉最后一个
                num = num.substring(0, num.length() - 1);
            }
        }
        return "".equals(num) ? "0" : trimZero(num);
    }

    private String trimZero(String str){
        int index = 0;
        for(int i = 0; i < str.length(); i++){
            index = i;
            if(str.charAt(i) != '0'){
                break;
            }
        }
        return str.substring(index, str.length());
    }

    @Test
    public void test(){
        RemoveKdigits removeKdigits = new RemoveKdigits();
        String s = removeKdigits.removeKdigits("0000223", 1);
        log.info("s={}", s);
    }

}
