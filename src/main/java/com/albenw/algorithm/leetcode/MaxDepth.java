package com.albenw.algorithm.leetcode;
import static com.albenw.algorithm.utils.TreeNodeUtil.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020-09-02.
 * leetcode 104. 二叉树的最大深度
 */

@Slf4j
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    @Test
    public void test1(){
        MaxDepth maxDepth = new MaxDepth();
        int i = maxDepth.maxDepth(getData());
        log.info("i={}", i);
    }

    private TreeNode getData(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n2.right = n3;
        n1.right = n4;
        return n1;
    }

}
