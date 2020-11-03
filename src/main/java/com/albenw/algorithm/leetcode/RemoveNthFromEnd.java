package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/19.
 * leetcode 19. 删除链表的倒数第N个节点
 */
@Slf4j
public class RemoveNthFromEnd {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode p1 = head;
        int count = 0;
        //当p1走到尽头时，p2实际指向倒数第n-1个节点
        ListNode p2 = null;
        while (p1.next != null) {
            p1 = p1.next;
            count++;
            if(count == n){
                p2 = head;
            }else if(p2 != null){
                p2 = p2.next;
            }
        }
        // n大于链表的长度
        if(n > count + 1) {
            return null;
        }
        //删除第一个节点
        if(p2 == null){
            head = head.next;
        }else if(p2.next != null){
            //删除节点
            p2.next = p2.next.next;
        }
        return head;
    }

    @Test
    public void test1(){
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();

        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(4);
//        ListNode l4 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;

        ListNode listNode = removeNthFromEnd.removeNthFromEnd(l1, 1);
        while(listNode != null){
            log.info("i->{}", listNode.val);
            listNode = listNode.next;
        }
    }
}
