package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/12.
 * leetcode 234 - 回文链表
 * 1、转为数组用下标判断
 * 2、找出中间节点（如果是偶数则是右边中位节点）；反转后半部的链表；然后前后两个链表做比较即可
 */
@Slf4j
public class PalindromeLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMidNode(head);
        ListNode reverseHead = reverse(mid);
        while(reverseHead != null){
            if(head.val != reverseHead.val){
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    /**
     * 快慢指针获取中间节点
     * @param head
     * @return
     */
    private ListNode getMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 反转链表，记住 pre, cur, next
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void test1(){
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        boolean palindrome = palindromeLinkedList.isPalindrome(head);
        log.info("palindrome={}", palindrome);
    }

}
