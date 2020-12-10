package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * @author alben.wong
 * @since 2020/12/10.
 * leetcode 860. 柠檬水找零
 *
 */
@Slf4j
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] values = new int[]{5, 10, 20};
        for(int i = 0; i < bills.length; i++){
            int change = bills[i] - 5;
            if(change > 0){
                //贪心找零钱
                for(int j = values.length - 1; j >= 0; j--){
                    Integer remain = map.get(values[j]);
                    if(remain != null && remain > 0 && change >= values[j]){
                        int needCount = change / values[j];
                        if(needCount - remain > 0){
                            map.put(values[j], 0);
                            change -= remain * values[j];
                        }else{
                            map.put(values[j], map.get(values[j]) - needCount);
                            change -= needCount * values[j];
                        }
                    }
                }
                if(change > 0){
                    return false;
                }
            }
            map.put(bills[i], map.getOrDefault(bills[i], 0) + 1);
        }
        return true;
    }

    @Test
    public void test(){
        LemonadeChange lemonadeChange = new LemonadeChange();
        int[] nums = new int[]{5,5,10,10,5,20};
        boolean b = lemonadeChange.lemonadeChange(nums);
        log.info("b={}", b);
    }

}
