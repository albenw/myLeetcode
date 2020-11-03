package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/11/1.
 * leetcode 337. 打家劫舍 III
 * 这题肯定是考测树的遍历相关的
 * 第一思路用dfs，对于一个节点要么visit要么不visit，如果visit了，那么其直接子节点不能visit了
 *
 * 但是由于每个节点的选择会影响到后面节点的选择，所以这个需要记录下来
 */
@Slf4j
public class RobV2 {

    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    /**
     * dp[0]表示"不选择"当前节点得到的最大值
     * dp[1]表示"选择"当前节点得到的最大值
     * @param node
     * @return
     */
    private int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{0, 0};
        }
        //用后序遍历，是因为要通过左右子树得到父节点的最大值
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        //父节点的最大值
        int[] dp = new int[2];
        //当父节点选择时 = 自身值 + 左右节点不选时的最大值
        dp[1] = node.val + left[0] + right[0];
        //当父亲节点不选择时 = 左右节点选或不选的最大值
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return dp;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void test(){
        RobV2 robV2 = new RobV2();
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n2.right = n5;

        int rob = robV2.rob(root);
        log.info("rob={}", rob);
    }

}
