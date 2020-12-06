package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import static com.albenw.algorithm.utils.ListNodeUtil.ListNode;
/**
 * @author alben.wong
 * @since 2020/10/19.
 * leetcode 21. 合并两个有序链表
 * 难度不大，不过挺考验写代码的能力
 *
 * 有三种写法
 * 1、普通串在一起（代码比较长）
 * 2、新建一个dummyHead来做新的头节点，代码会简洁好多，返回dummyHead.next就好
 * 3、用递归
 */
@Slf4j
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        return mergeTwoLists_V2(l1, l2);
    }

    public ListNode mergeTwoLists_V1(ListNode l1, ListNode l2) {
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

    /**
     * dummyHead方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_V2(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode prehead = dummy;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    /**
     * 递归方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_V3(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists_V3(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists_V3(l1, l2.next);
            return l2;
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
