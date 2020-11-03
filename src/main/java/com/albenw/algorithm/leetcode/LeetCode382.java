package com.albenw.algorithm.leetcode;

import java.util.Random;

/**
 * @author alben.wong
 * @since 2020/9/24.
 */
public class LeetCode382 {

    private ListNode head;

    public LeetCode382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int count = 0;
        ListNode tmp = head.next;
        int res = head.val;
        while (tmp != null){
            count++;
            Random random = new Random();
            int r = random.nextInt(count + 1);
            if(r == 0){
                res = tmp.val;
            }
            tmp = tmp.next;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
