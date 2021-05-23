package com.albenw.algorithm.leetcode;

import com.albenw.algorithm.utils.ListNodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import static com.albenw.algorithm.utils.ListNodeUtil.*;

/**
 * @author alben.wong
 * @since 2020-08-30.
 * leetcode 2. 两数相加
 * 这题不难，比价考察代码能力
 */

@Slf4j
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode pre = null;
        ListNode start = null;
        boolean addition = false;
        while(cur1 != null || cur2 != null || addition){
            if(cur1 == null && cur2 == null && addition){
//                constructNode(pre, 1);
                addition = false;
                continue;
            }
            int val1 = cur1 == null ? 0 : cur1.val;
            int val2 = cur2 == null ? 0 : cur2.val;
            int value = val1 + val2;
            if(addition){
                value = value + 1;
            }
            if(value >= 10){
                value = value % 10;
                addition = true;
            }else{
                addition = false;
            }
//            ListNode node = constructNode(pre, value);
            ListNode node = null;
            if(pre == null){
                start = node;
            }
            pre = node;
            if(cur1 != null){
                cur1 = cur1.next;
            }
            if(cur2 != null){
                cur2 = cur2.next;
            }
        }
        return start;
    }

    @Test
    public void test1(){
        ListNode l1 = ListNodeUtil.createByArray(Arrays.asList(1, 2, 3));
        ListNode l2 = ListNodeUtil.createByArray(Arrays.asList(2, 5, 7));
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        print(listNode);
    }

}
