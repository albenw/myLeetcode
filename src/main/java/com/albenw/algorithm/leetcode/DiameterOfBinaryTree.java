package com.albenw.algorithm.leetcode;
import com.albenw.algorithm.utils.TreeNodeUtil;
import com.albenw.algorithm.utils.TreeNodeUtil.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author alben.wong
 * @since 2020/11/5.
 * leetcode 543. 二叉树的直径
 * 这题肯定是用dfs了，思路是求出左右子树最大深度，然后相加，一直dfs下去
 * 踩坑了，"最大直径"不一定经过根节点，所以需要计算所有的节点
 * 应该是自下而上。。
 */
@Slf4j
public class DiameterOfBinaryTree{

    private int res = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return res - 1;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        res = Math.max(left + right + 1, res);
        return Math.max(left, right) + 1;
    }

    @Test
    public void test(){
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        TreeNode root = TreeNodeUtil.createByArray(Arrays.asList(1,2,3,4,5));
        int i = diameterOfBinaryTree.diameterOfBinaryTree(root);
        log.info("i={}", i);
    }

}
