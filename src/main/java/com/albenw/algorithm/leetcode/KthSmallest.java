package com.albenw.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/10/22.
 * leetcode 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {

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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> orderValues = new ArrayList<>();
        inOrder(root, orderValues);
        return orderValues.get(k - 1);
    }

    private void inOrder(TreeNode node, List<Integer> orderValues){
        if(node.left != null){
            inOrder(node.left, orderValues);
        }
        orderValues.add(node.val);
        if(node.right != null){
            inOrder(node.right, orderValues);
        }
    }

}
