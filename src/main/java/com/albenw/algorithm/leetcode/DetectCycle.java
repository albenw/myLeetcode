package com.albenw.algorithm.leetcode;

/**
 * @author alben.wong
 * @since 2020/10/22.
 * leetcode 142. 环形链表 II
 * 这题是要求出入环点
 */
public class DetectCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 利用快慢指针，可以得出: 从相遇点到入环点的距离加上 n-1n−1 圈的环长，恰好等于从链表头部到入环点的距离
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do{
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            //得到相遇点
            if(slow == fast){
                break;
            }
        }while (slow != null && fast != null);
        //不存在环
        if(fast == null){
            return null;
        }
        //一个从相遇点开始走，一个从起点开始走，直到相遇
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
