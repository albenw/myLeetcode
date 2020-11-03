package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/10/22.
 * leetcode 94. 二叉树的中序遍历
 */
@Slf4j
public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> all = new ArrayList<>();
        inorderTraversals(root, all);
        return all;
    }

    public void inorderTraversals(TreeNode node, List<Integer> inOrderValues){
        if(node.left != null){
            inorderTraversals(node.left, inOrderValues);
        }
        inOrderValues.add(node.val);
        if(node.right != null){
            inorderTraversals(node.right, inOrderValues);
        }
    }

    @Test
    public void test1(){
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode root = new TreeNode();
        List<Integer> integers = inorderTraversal.inorderTraversal(root);
        log.info("integers={}", integers);
    }

}
