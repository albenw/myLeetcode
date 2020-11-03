package com.albenw.algorithm.leetcode;

/**
 * @author alben.wong
 * @since 2020-08-29.
 * leetcode 98. 验证二叉搜索树
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static com.albenw.algorithm.utils.TreeNodeUtil.*;

@Slf4j
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        List<Integer> inOrderValues = new ArrayList<>();
        inOrderTraversal(root, inOrderValues);
        return isAscendingOrder(inOrderValues);
    }

    //中序遍历
    private void inOrderTraversal(TreeNode root, List<Integer> inOrderValues){
        if(root.left != null){
            inOrderTraversal(root.left, inOrderValues);
        }
        inOrderValues.add(root.val);
        if(root.right != null){
            inOrderTraversal(root.right, inOrderValues);
        }
    }

    private boolean isAscendingOrder(List<Integer> inOrderValues){
        if(inOrderValues == null){
            return true;
        }
        for(int i = 0; i < inOrderValues.size() - 1; i++){
            if(inOrderValues.get(i + 1) <= inOrderValues.get(i)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        IsValidBST isValidBST = new IsValidBST();
        boolean validBST = isValidBST.isValidBST(getRoot());
        log.info("validBST={}", validBST);
    }

    private TreeNode getRoot(){
        TreeNode root = new TreeNode(10);
        TreeNode l1 = new TreeNode(10);
        TreeNode r1 = new TreeNode(20);
        TreeNode r11 = new TreeNode(9);
        TreeNode r12 = new TreeNode(30);
        r1.left = r11;
        r1.right = r12;
        root.left = l1;
        root.right = r1;
        return root;
    }

}
