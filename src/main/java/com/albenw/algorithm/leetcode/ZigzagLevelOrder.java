package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

import static com.albenw.algorithm.utils.TreeNodeUtil.*;

/**
 * @author alben.wong
 * @since 2020/12/21.
 * leetcode 103. 二叉树的锯齿形层次遍历
 *
 * 感觉比较简单，在bfs的基础上增加一个先进左子树还是右子树的判断
 *
 */
@Slf4j
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        bfs(res, deque);
        return res;
    }

    public void bfs(List<List<Integer>> res, Deque<TreeNode> deque){
        boolean ltr = true;
        while (!deque.isEmpty()){
            List<TreeNode> tmpNode = new LinkedList<>();
            while (!deque.isEmpty()){
                tmpNode.add(deque.pollLast());
            }
            List<Integer> tr = new ArrayList<>();
            for(TreeNode n : tmpNode){
                tr.add(n.val);
            }
            res.add(tr);
            ltr = !ltr;
            for(TreeNode n : tmpNode){
                if (ltr) {
                    if(n.right != null){
                        deque.addLast(n.right);
                    }
                    if(n.left != null){
                        deque.addLast(n.left);
                    }
                } else {
                    if(n.left != null){
                        deque.addLast(n.left);
                    }
                    if(n.right != null){
                        deque.addLast(n.right);
                    }
                }
            }
        }
    }

    @Test
    public void test(){
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        //3,9,20,null,null,15,7
        //0,2,4,1,null,3,-1,5,1,null,6,null,8
        TreeNode byArray = createByArray(Arrays.asList(3,9,20,null,null,15,7));
        List<List<Integer>> lists = zigzagLevelOrder.zigzagLevelOrder(byArray);
        log.info("lists={}", lists);
    }

}
