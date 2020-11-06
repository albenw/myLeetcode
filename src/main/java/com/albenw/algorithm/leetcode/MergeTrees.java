package com.albenw.algorithm.leetcode;
import com.albenw.algorithm.utils.TreeNodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.albenw.algorithm.utils.TreeNodeUtil.TreeNode;

/**
 * @author alben.wong
 * @since 2020/11/5.
 * leetcode 617. 合并二叉树
 * 同时进行dfs
 * easy～
 */
@Slf4j
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        dfs(t1, t2, root);
        return root;
    }

    private void dfs(TreeNode t1, TreeNode t2, TreeNode mergeNode){
        if(t1 == null && t2 == null){
            return;
        }
        TreeNode t1Left = t1 == null ? null : t1.left;
        TreeNode t2Left = t2 == null ? null : t2.left;
        if(t1Left != null || t2Left != null){
            TreeNode left = new TreeNode((t1Left == null ? 0 : t1Left.val) + (t2Left == null ? 0 : t2Left.val));
            mergeNode.left = left;
            dfs(t1Left, t2Left, left);
        }
        TreeNode t1Right = t1 == null ? null : t1.right;
        TreeNode t2Right = t2 == null ? null : t2.right;
        if(t1Right != null || t2Right != null){
            TreeNode right = new TreeNode((t1Right == null ? 0 : t1Right.val) + (t2Right == null ? 0 : t2Right.val));
            mergeNode.right = right;
            dfs(t1Right, t2Right, right);
        }
    }

    @Test
    public void test(){
        MergeTrees mergeTrees = new MergeTrees();
        TreeNode t1 = TreeNodeUtil.createByArray(Arrays.asList(1, 3, 2, 5));
        TreeNode t2 = TreeNodeUtil.createByArray(Arrays.asList(2, 1, 3, null, 4, null, 7));
        TreeNode treeNode = mergeTrees.mergeTrees(t1, t2);
        List<Integer> bfs = TreeNodeUtil.bfs(treeNode);
        log.info("bfs={}", bfs);
    }

}
