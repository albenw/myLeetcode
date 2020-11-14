package com.albenw.algorithm.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/11/13.
 */
@Slf4j
public class ListNodeUtil {

    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode createByArray(List<Integer> nums){
        ListNode head = new ListNode(nums.get(0));
        ListNode node = head;
        for(int i = 1; i < nums.size(); i++){
            ListNode tmp = new ListNode(nums.get(i));
            node.next = tmp;
            node = tmp;
        }
        return head;
    }

    public static void print(ListNode head){
        List<Integer> res = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            res.add(node.val);
            node = node.next;
        }
        log.info("print={}", res);
    }

    @Test
    public void test(){
        ListNode byArray = ListNodeUtil.createByArray(Arrays.asList(1, 2, 3, 4));
        ListNodeUtil.print(byArray);
    }

}
