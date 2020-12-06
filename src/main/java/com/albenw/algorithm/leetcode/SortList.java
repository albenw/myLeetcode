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

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    @Test
    public void test(){
        SortList sortList = new SortList();
        ListNode head = ListNodeUtil.createByArray(Arrays.asList(-1, 5, 3, 4, 0));
        ListNode listNode = sortList.sortList(head);
        ListNodeUtil.print(listNode);
    }

}
