package com.albenw.algorithm.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author alben.wong
 * @since 2020/11/2.
 */
@Slf4j
public class TreeNodeUtil {

    public static class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(Integer x) {
            val = x;
        }
    }

    public static List<Integer> bfs(TreeNode node){
        if(node == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(node);
        while (!deque.isEmpty()){
            TreeNode treeNode = deque.pollLast();
            res.add(treeNode.val);
            if(treeNode.left != null || treeNode.right != null){
                if(treeNode.left != null){
                    deque.addFirst(treeNode.left);
                }else{
                    deque.addFirst(new TreeNode(null));
                }
                if(treeNode.right != null){
                    deque.addFirst(treeNode.right);
                }else{
                    deque.addFirst(new TreeNode(null));
                }
            }
        }
        return res;
    }

    /**
     * 前序遍历
     * @param node
     * @return
     */
    public static List<Integer> preOrder(TreeNode node){
        List<Integer> res = new ArrayList<>();
        preOrder(node, res);
        return res;
    }

    private static void preOrder(TreeNode node, List<Integer> res){
        if(node != null){
            res.add(node.val);
        }
        if(node.left != null){
            preOrder(node.left, res);
        }
        if(node.right != null){
            preOrder(node.right, res);
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

    @Test
    public void bfsTest(){
        List<Integer> list = Arrays.asList(1, 2, 3, null, 4, null, 5);
        TreeNode root = TreeNodeUtil.createByArray(list);
        List<Integer> bfs = TreeNodeUtil.bfs(root);
        log.info("bfs={}", bfs);
    }

    @Test
    public void preOrderTest(){
        TreeNode byArray = TreeNodeUtil.createByArray(Arrays.asList(1, 2, 5, 3, 4, null, 6));
        List<Integer> integers = preOrder(byArray);
        log.info("integers={}", integers);
    }

}
