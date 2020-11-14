package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/14.
 * leetcode 925. 长按键入
 * 这题不难，不过对边界的处理要小心，需要思考清楚
 */
@Slf4j
public class IsLongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        if(name.length() == 0 || typed.length() == 0){
            return false;
        }
        int p = 0;
        int q = 0;
        while(q < typed.length()){
            //相等
            if(p < name.length() && name.charAt(p) == typed.charAt(q)){
                q++;
                p++;
            }else{
                //不相等
                if(q > 0 && typed.charAt(q) == typed.charAt(q - 1)){
                    q++;
                }else{
                    return false;
                }
            }
        }
        return p == name.length();
    }

    @Test
    public void test(){
        IsLongPressedName isLongPressedName = new IsLongPressedName();
        boolean longPressedName = isLongPressedName.isLongPressedName("vtkgn", "vttkgnn");
        log.info("longPressedName={}", longPressedName);
    }

}
