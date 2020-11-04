package com.albenw.algorithm.leetcode;

/**
 * @author alben.wong
 * @since 2020/10/19.
 * leetcode 141 链表是否有环
 * 经典：快慢指针
 */
public class HasCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 用快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do{
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if(slow == fast){
                return true;
            }
        }while (slow != null && fast != null);
        return false;
    }

}
