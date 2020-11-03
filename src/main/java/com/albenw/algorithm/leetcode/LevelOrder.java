package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.albenw.algorithm.utils.TreeNodeUtil.*;

/**
 * @author alben.wong
 * @since 2020-09-01.
 * leetcode 102. 二叉树的层序遍历
 */

@Slf4j
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while(queue.size() > 0){
            //当前节点全部取出来，再将它们的子节点加入到队列中
            List<TreeNode> nodes = new ArrayList<>();
            while(queue.size() > 0){
                nodes.add(queue.poll());
            }
            addToResult(nodes, result);
            addToQueue(nodes, queue);
        }
        return result;
    }

    private void addToResult(List<TreeNode> nodes, List<List<Integer>> result){
        List<Integer> list = new ArrayList<>();
        for(TreeNode node : nodes){
            if(node != null){
                list.add(node.val);
            }
        }
        if(list.size() > 0){
            result.add(list);
        }
    }

    private void addToQueue(List<TreeNode> nodes, Queue<TreeNode> queue){
        for(TreeNode node : nodes){
            if(node != null && node.left != null){
                queue.offer(node.left);
            }
            if(node != null && node.right != null){
                queue.offer(node.right);
            }
        }
    }

    @Test
    public void test1(){
        LevelOrder levelOrder = new LevelOrder();
        TreeNode root = getData();
        List<List<Integer>> lists = levelOrder.levelOrder(root);
        log.info("lists={}", lists);
    }

    private TreeNode getData(){
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        n1.left = n5;

        return root;
    }

}
