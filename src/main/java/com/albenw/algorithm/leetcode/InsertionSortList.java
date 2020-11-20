package com.albenw.algorithm.leetcode;
import com.albenw.algorithm.utils.ListNodeUtil;
import org.junit.Test;

import java.util.Arrays;

import static com.albenw.algorithm.utils.ListNodeUtil.ListNode;
/**
 * @author alben.wong
 * @since 2020/11/20.
 * leetcode 147. 对链表进行插入排序
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null){
            ListNode q = head;
            ListNode preq = null;
            boolean flag = false;
            while (q != null && q != cur){
                //找到第一个大于的节点
                if(q.val > cur.val){
                    pre.next = cur.next;
                    if(preq != null){
                        preq.next = cur;
                    }else{
                        head = cur;
                    }
                    cur.next = q;
                    flag = true;
                }
                if(flag){
                    break;
                }
                preq = q;
                q = q.next;
            }
            if(flag){
                cur = pre.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    @Test
    public void test(){
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode byArray = ListNodeUtil.createByArray(Arrays.asList(-1, 5, 3, 4,0));
        ListNode head = insertionSortList.insertionSortList(byArray);
        ListNodeUtil.print(head);
    }

}
