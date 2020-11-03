package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/19.
 * leetcode 21. 合并两个有序链表
 * 难度不大，不过挺考验写代码的能力
 */
@Slf4j
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode last = null;
        ListNode head = null;
        while(l1 != null && l2 != null){
            ListNode tmp = l1.val <= l2.val ? l1 : l2;
            if(last == null){
                last = tmp;
                head = last;
            }else{
                last.next = tmp;
                last = last.next;
            }
            if(l1.val <= l2.val){
                l1 = l1.next;
            }else{
                l2 = l2.next;
            };
        }
        while (l1 != null){
            last.next = l1;
            last = last.next;
            l1 = l1.next;
        }
        while(l2 != null){
            last.next = l2;
            last = last.next;
            l2 = l2.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(6);
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(l1, l4);
        while (listNode != null){
            log.info("i->{}", listNode.val);
            listNode = listNode.next;
        }
    }

}
