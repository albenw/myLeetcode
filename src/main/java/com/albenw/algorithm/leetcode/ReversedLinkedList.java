package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020-08-23.
 * leetcode 206 反转链表
 */
@Slf4j
public class ReversedLinkedList {

    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode next = null;
        ListNode node = head;
        while(node != null){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    /**
     *  递归做法:
     *         if(head == null || head.next == null) return head;
     *         ListNode p = reverseList(head.next); //递归
     *         head.next.next = head; //反转两个方向
     *         head.next = null;
     *         return p;
     */
    /**
     * 假设链表为 n1 -> nk-1 -> nk -> nk+1 -> nm -> null
     * 若 nk+1 到 nm 已被反转了
     * n1 -> nk-1 -> nk -> nk+1 <- nm
     * 我们希望 nk+1 的下一个节点是 nk
     * 所以 nk.next.next = nk
     * 要小心n1的next为null
     */

    @Test
    public void test1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node = ReversedLinkedList.reverseList(node1);
        print(node);
    }

    public void print(ListNode node){
        while(node != null){
            log.info("" + node.val);
            node = node.next;
        }
    }
}
