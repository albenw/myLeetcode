package com.albenw.algorithm.leetcode;

/**
 * @author alben.wong
 * @since 2020/10/17.
 * leetcode 160. 相交链表
 * 1、用一个hashmap保存一个表的节点，然后遍历另外一个链表查
 * 2、对于指针x走完A之后走完，指针y也是，当x和y相等时，他们所处的就是A和B相交点
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
