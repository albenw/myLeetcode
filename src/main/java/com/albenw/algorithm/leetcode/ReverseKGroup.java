package com.albenw.algorithm.leetcode;

import com.albenw.algorithm.utils.ListNodeUtil;
import org.junit.Test;
import com.albenw.algorithm.utils.ListNodeUtil.ListNode;

import java.util.Arrays;

/**
 * @author alben.wong
 * @since 2021/2/24.
 * leetcode - 25. K 个一组翻转链表
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2){
            return head;
        }
        //dummy永远为"head"的前一个
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null){
            //因为pre为上一个子链表的tail（除了翻转第一个子链表时除外）
            ListNode tail = pre;
            //新子链表的tail一直走，找k个一组
            for(int  i = 0; i < k; i++){
                tail = tail.next;
                if(tail == null){
                    //不足k个，直接返回
                    return dummy.next;
                }
            }
            //找到后标记nex为子链表下一个节点
            ListNode nex = tail.next;
            //翻转子链表
            ListNode[] reverse = reverseList(head, tail);
            head = reverse[0];
            tail = reverse[1];
            //拼接好子链表的前后端
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    /**
     * 翻转一个子链表
     * 注意翻转的tail要和原tail的next接上
     * @param head
     * @param tail
     * @return
     */
    private ListNode[] reverseList(ListNode head, ListNode tail) {
        //因为翻转后的原head肯定需要指向tail.next的
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail){
            //保留现场，将p指向pre
            ListNode nex = p.next;
            p.next = pre;
            pre = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    @Test
    public void test() {
        ListNode byArray = ListNodeUtil.createByArray(Arrays.asList(1, 2, 3, 4, 5));
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode newHead = reverseKGroup.reverseKGroup(byArray, 2);
        ListNodeUtil.print(newHead);
    }
}
