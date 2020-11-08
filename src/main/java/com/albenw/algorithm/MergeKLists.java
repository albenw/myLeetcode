package com.albenw.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/6.
 * leetcode 23. 合并K个升序链表
 * 这题考察分治，跟归并排序类似
 */
@Slf4j
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        int mid = (left + right) / 2;
        //注意merge方法的返回表示的含义：归并的结果
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        //最后两个汇总在一起
        return mergeTwoList(l1, l2);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = null;
        ListNode pre = null;
        while(p != null && q != null){
            //取出较小的那个节点
            ListNode node;
            if(p.val > q.val){
                node = q;
                q = q.next;
            }else{
                node = p;
                p = p.next;
            }
            if(head == null){
                head = node;
            }else{
                pre.next = node;
            }
            pre = node;
        }
        ListNode rest = p == null ? q : p;
        while(rest != null){
            pre.next = rest;
            pre = rest;
            rest = rest.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @Test
    public void mergeTwoListTest(){
        MergeKLists mergeKLists = new MergeKLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        ListNode listNode = mergeKLists.mergeTwoList(l1, l2);
        printList(listNode);
    }

    private void printList(ListNode list){
        while(list != null){
            log.info("" + list.val);
            list = list.next;
        }
    }

    @Test
    public void test(){
        MergeKLists mergeKLists = new MergeKLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{
                l1, l2, l3
        };
        ListNode listNode = mergeKLists.mergeKLists(lists);
        printList(listNode);
    }

}
