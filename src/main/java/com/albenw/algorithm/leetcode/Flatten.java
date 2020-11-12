package com.albenw.algorithm.leetcode;
import com.albenw.algorithm.utils.TreeNodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.albenw.algorithm.utils.TreeNodeUtil.TreeNode;
/**
 * @author alben.wong
 * @since 2020/11/12.
 * leetcode 114. 二叉树展开为链表
 * 按照前序遍历得到结果
 * 题目要求"原地"修改，即不能先通过前序遍历得到结果，然后组装成结果
 * 初步想法是在进行前序遍历时就修改树，按照前序遍历的递归逻辑，把node的左子树变为右子树，而右子树变为左子树的最右子树
 */
@Slf4j
public class Flatten {

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        preOrderTraverse(root);
    }

    private void preOrderTraverse(TreeNode node){
        TreeNode left = null;
        TreeNode right = null;
        if(node.left != null){
            left = node.left;
            preOrderTraverse(left);
        }
        if(node.right != null){
            right = node.right;
            preOrderTraverse(right);
        }
        //左子树变为右子树，左子树变为null
        if(left != null){
            node.right = left;
            node.left = null;
        }
        //右子树变为左子树的最右子树
        if(left != null){
            TreeNode tmp = left;
            while(tmp.right != null){
                tmp = tmp.right;
            }
            tmp.right = right;
        }
    }

    @Test
    public void test(){
        Flatten flatten = new Flatten();
        TreeNode byArray = TreeNodeUtil.createByArray(Arrays.asList(1, 2));
        flatten.flatten(byArray);
        List<Integer> integers = TreeNodeUtil.preOrder(byArray);
        log.info("integers={}", integers);
    }

}
