package com.albenw.algorithm.leetcode;
import com.albenw.algorithm.utils.ListNodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static com.albenw.algorithm.utils.ListNodeUtil.ListNode;
/**
 * @author alben.wong
 * @since 2020/11/19.
 * leetcode 24. 两两交换链表中的节点
 */
@Slf4j
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null){
            if(pre != null){
                pre.next = cur.next;
            }else{
                head = cur.next;
            }
            ListNode tmp = next.next;
            next.next = cur;
            cur.next = tmp;
            //下一个
            pre = cur;
            next = cur.next == null ?  null : cur.next.next;
            cur = cur.next;
        }
        return head;
    }

    @Test
    public void test(){
        SwapPairs swapPairs = new SwapPairs();
        ListNode head = ListNodeUtil.createByArray(Arrays.asList(1, 2, 3, 4, 5));
        ListNode newHead = swapPairs.swapPairs(head);
        ListNodeUtil.print(newHead);
    }

}
