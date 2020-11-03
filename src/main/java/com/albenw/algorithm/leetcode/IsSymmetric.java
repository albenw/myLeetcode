package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/11/2.
 * leetcode 101. 对称二叉树
 * 判断树是否镜像对称
 * 用中序遍历，然后判断是否对称 -> 这个方法是不行。。（因为输出后的list已经丢失了树形的结构，看对称是不对的，有可能是刚好数字对上而已）
 * 用dfs，不过使用两个指针来来左右子树是否相等，原理是如果一个树是对称，那么它的左右子树也是对称的
 */
@Slf4j
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    private void inOrderTraverse(TreeNode node, List<Integer> values){
        if(node.left == null && node.right == null){
            values.add(node.val);
            return;
        }
        if(node.left != null){
            inOrderTraverse(node.left, values);
        }else{
            values.add(null);
        }
        values.add(node.val);
        if(node.right != null){
            inOrderTraverse(node.right, values);
        }else{
            values.add(null);
        }
    }

    private boolean isSymmetricList(List<Integer> values){
        int left = 0;
        int right = values.size() - 1;
        while(left <= right){
            if(values.get(left) != values.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void test(){
        IsSymmetric isSymmetric = new IsSymmetric();
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);
        log.info("list={}", list);
        boolean symmetric = isSymmetric.isSymmetric(root);
        log.info("symmetric={}", symmetric);
    }

}
