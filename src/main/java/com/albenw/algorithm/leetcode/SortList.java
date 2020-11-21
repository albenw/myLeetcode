package com.albenw.algorithm.leetcode;
import com.albenw.algorithm.utils.ListNodeUtil;
import org.junit.Test;

import java.util.Arrays;

import static com.albenw.algorithm.utils.ListNodeUtil.ListNode;
/**
 * @author alben.wong
 * @since 2020/11/21.
 * leetcode 148. 排序链表
 * 这题需要在O(logn)下对链表进行排序，觉得只有归并排序比较适合链表
 * (思路是有了，不过想不到怎么写代码，下不了手)
 *
 * 这题挺难的，不过也挺有意思的，可以把之前的题都一起做了，如找一个链表中间节点，合并两个有序链表
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail){
        if(head == null){
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode mid = findMidNode(head, tail);
        ListNode l1 = sortList(head, mid);
        ListNode l2 = sortList(mid, tail);
        return mergeTwoLists(l1, l2);
    }

    /**
     * 找到两个节点的中间节点
     * @param head
     * @param tail
     * @return
     */
    private ListNode findMidNode(ListNode head, ListNode tail){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        return slow;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    @Test
    public void test(){
        SortList sortList = new SortList();
        ListNode head = ListNodeUtil.createByArray(Arrays.asList(-1, 5, 3, 4, 0));
        ListNode listNode = sortList.sortList(head);
        ListNodeUtil.print(listNode);
    }

}
