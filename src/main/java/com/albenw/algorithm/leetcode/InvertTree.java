package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/29.
 * leetcode 226. 翻转二叉树
 * 按照例子的意思是反转左右子树的位置
 */
@Slf4j
public class InvertTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        invert(root);
        return root;
    }

    private void invert(TreeNode parent){
        if(parent == null){
            return;
        }
        TreeNode tmpLeft = parent.left;
        TreeNode tmpRight = parent.right;
        parent.left = tmpRight;
        parent.right = tmpLeft;
        //递归子的反转
        invert(tmpLeft);
        invert(tmpRight);
    }

    @Test
    public void test(){
        InvertTree invertTree = new InvertTree();
        TreeNode root = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(7);
        root.left = l1;
        root.right = l2;
//        TreeNode l3 = new TreeNode(1);
//        TreeNode l4 = new TreeNode(3);
//        l1.left = l3;
//        l1.right = l4;
//        TreeNode l5 = new TreeNode(6);
//        TreeNode l6 = new TreeNode(9);
//        l2.left = l5;
//        l2.right = l6;
        inOrderPrint(root);
        invertTree.invert(root);
        inOrderPrint(root);
    }

    private void inOrderPrint(TreeNode root){
        if(root.left != null){
            inOrderPrint(root.left);
        }
        log.info("_" + root.val);
        if(root.right != null){
            inOrderPrint(root.right);
        }
    }
}
