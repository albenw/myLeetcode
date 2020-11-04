package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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
                constructNode(pre, 1);
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
            ListNode node = constructNode(pre, value);
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

    private ListNode constructNode(ListNode pre, int value){
        ListNode node = new ListNode(value);
        if(pre != null){
            pre.next = node;
        }
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void test1(){
        ListNode n1 = new ListNode(5);
//        ListNode n2 = new ListNode(8);
//        ListNode n3 = new ListNode(3);

        ListNode n4 = new ListNode(5);
//        ListNode n5 = new ListNode(6);
//        ListNode n6 = new ListNode(4);

//        n1.next = n2;
//        n2.next = n3;

//        n4.next = n5;
//        n5.next = n6;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(n1, n4);
        print(listNode);
    }

    private void print(ListNode node){
        while (node != null){
            log.info(node.val + "");
            node = node.next;
        }
    }

}
