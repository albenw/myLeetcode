package com.albenw.algorithm.leetcode;
import com.albenw.algorithm.utils.TreeNodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

import static com.albenw.algorithm.utils.TreeNodeUtil.TreeNode;
/**
 * @author alben.wong
 * @since 2020/11/14.
 * leetcode 129. 求根到叶子节点数字之和
 * 用dfs
 */
@Slf4j
public class SumNumbers {

    private int res = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, new LinkedList<>());
        return res;
    }

    private void dfs(TreeNode node, Deque<Integer> path){
        if(node == null){
            return;
        }
        path.addLast(node.val);
        //叶子处理结果
        if(node.left == null && node.right == null){
            Integer sum = getNumber(path);
            res += sum;
            return;
        }
        dfs(node.left, path);
        if(node.left != null){
            path.removeLast();
        }
        dfs(node.right, path);
        if(node.right != null){
            path.removeLast();
        }
    }

    private Integer getNumber(Deque<Integer> path){
        int sum = 0;
        for(Integer num : path){
            sum = sum * 10 + num;
        }
        return sum;
    }

    @Test
    public void test(){
        SumNumbers sumNumbers = new SumNumbers();
        TreeNode byArray = TreeNodeUtil.createByArray(Arrays.asList(4,9,0,5,1));
        int i = sumNumbers.sumNumbers(byArray);
        log.info("i={}", i);
    }

}
