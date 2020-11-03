package com.albenw.algorithm.utils;

import org.junit.Test;

import java.util.*;

/**
 * @author alben.wong
 * @since 2020/11/2.
 */
public class TreeNodeUtil {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 根据数组创建一个树
     * @param list
     * @return root
     */
    public static TreeNode createByArray(List<Integer> list){
        if(list == null || list.size() == 0){
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(list.get(0));
        deque.addLast(root);
        int index = 1;
        while (!deque.isEmpty()){
            TreeNode parent = deque.pollFirst();
            if(index < list.size()){
                if(list.get(index) != null){
                    TreeNode left = new TreeNode(list.get(index));
                    deque.addLast(left);
                    parent.left = left;
                }
                index++;
            }
            if(index < list.size()){
                if(list.get(index) != null){
                    TreeNode right = new TreeNode(list.get(index));
                    deque.addLast(right);
                    parent.right = right;
                }
                index++;
            }
        }
        return root;
    }

    @Test
    public void createByArrayTest(){
        List<Integer> list = Arrays.asList(1, 2, 3, null, 4, null, 5);
        TreeNode root = TreeNodeUtil.createByArray(list);
        assert root != null;
    }

}
