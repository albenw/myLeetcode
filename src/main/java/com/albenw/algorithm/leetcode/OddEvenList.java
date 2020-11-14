package com.albenw.algorithm.leetcode;
import com.albenw.algorithm.utils.ListNodeUtil;
import org.junit.Test;
import java.util.Arrays;
import static com.albenw.algorithm.utils.ListNodeUtil.ListNode;

/**
 * @author alben.wong
 * @since 2020/11/13.
 * leetcode 328. 奇偶链表
 * 两个指针交替进行
 *
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode evenHead = q;
        while(q != null && q.next != null){
            p.next = q.next;
            q.next = q.next.next;
            p = p.next;
            q = q.next;
        }
        p.next = evenHead;
        return head;
    }

    @Test
    public void test(){
        OddEvenList oddEvenList = new OddEvenList();
        ListNode byArray = ListNodeUtil.createByArray(Arrays.asList(1,2,3,4));
        ListNode listNode = oddEvenList.oddEvenList(byArray);
        ListNodeUtil.print(listNode);
    }

}
