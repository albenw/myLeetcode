package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import static com.albenw.algorithm.utils.TreeNodeUtil.*;

/**
 * @author alben.wong
 * @since 2020/11/2.
 * leetcode 112. 路径总和
 * 用dfs
 */
@Slf4j
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode node, int target){
        if(node == null){
            return false;
        }
        boolean left = dfs(node.left, target - node.val);
        boolean right = dfs(node.right, target - node.val);
        //这里还需要增加一个判断：叶子节点是否刚好凑够
        boolean b = node.left == null && node.right == null && (target - node.val) == 0;
        return left || right || b;
    }

    @Test
    public void test(){
        HasPathSum hasPathSum = new HasPathSum();
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(13);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(1);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.right = n8;

        boolean b = hasPathSum.hasPathSum(root, 17);
        log.info("b={}", b);
    }

}
