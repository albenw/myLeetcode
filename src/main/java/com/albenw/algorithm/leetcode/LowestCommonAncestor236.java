package com.albenw.algorithm.leetcode;
import com.albenw.algorithm.utils.TreeNodeUtil;
import com.albenw.algorithm.utils.TreeNodeUtil.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/11/3.
 * leetcode 236. 二叉树的最近公共祖先
 * 先找出p的所有父节点，然后在检查q的父节点是不是在其中
 */
@Slf4j
public class LowestCommonAncestor236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root){
            return root;
        }
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        findAllParent(root, parentMap);
        List<TreeNode> target = getNodeParent(root, p, parentMap);
        //查找q的parent是否在p的parent中
        TreeNode node = q;
        while(node != null){
            if(target.contains(node)){
                return node;
            }
            node = parentMap.get(node);
        }
        return null;
    }

    private void findAllParent(TreeNode root, HashMap<TreeNode, TreeNode> parentMap){
        if(root.left != null){
            parentMap.put(root.left, root);
            findAllParent(root.left, parentMap);
        }
        if(root.right != null){
            parentMap.put(root.right, root);
            findAllParent(root.right, parentMap);
        }
    }

    private List<TreeNode> getNodeParent(TreeNode root, TreeNode node, HashMap<TreeNode, TreeNode> parentMap){
        List<TreeNode> list = new ArrayList<>();
        TreeNode cur = node;
        list.add(cur);
        while(cur != root){
            TreeNode parent = parentMap.get(cur);
            list.add(parent);
            cur = parent;
        }
        return list;
    }

    @Test
    public void test(){
        LowestCommonAncestor236 lowestCommonAncestor236 = new LowestCommonAncestor236();
        TreeNode byArray = TreeNodeUtil.createByArray(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4));
        TreeNode treeNode = lowestCommonAncestor236.lowestCommonAncestor(byArray, byArray.left, byArray.right);
        log.info("treeNode={}", treeNode.val);
    }

}
