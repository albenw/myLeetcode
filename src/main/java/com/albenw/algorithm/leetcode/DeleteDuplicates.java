package com.albenw.algorithm.leetcode;

import com.albenw.algorithm.utils.ListNodeUtil;
import org.junit.Test;

import java.util.Arrays;

import static com.albenw.algorithm.utils.ListNodeUtil.*;

/**
 * @author alben.wong
 * @since 2021/6/1.
 * 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            if(pre == null){
                pre = cur;
                cur = cur.next;
                continue;
            }
            //删除重复
            if(pre.val == cur.val){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    @Test
    public void test(){
        ListNode head = createByArray(Arrays.asList(1,1,2,3,3));
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        deleteDuplicates.deleteDuplicates(head);
        ListNodeUtil.print(head);
    }
}
