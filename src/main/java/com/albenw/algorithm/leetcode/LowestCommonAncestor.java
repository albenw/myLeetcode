package com.albenw.algorithm.leetcode;

/**
 * @author alben.wong
 * @since 2020-08-30.
 * leetcode 235. 二叉搜索树的最近公共祖先
 * 这题理解的关键是，由于是二叉搜索树，节点是有序的，所以只需要找到第一个节点 p < node < q，这个就是最近公共祖先了
 */
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == root || q == root){
            return root;
        }
        //当前node偏大，往左继续找
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        //当前node偏小，往右边继续找
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test1(){

    }

}
