package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author alben.wong
 * @since 2020/10/10.
 * leetcode 51
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 用DFS，一行一行来，如果某一行的皇后达不到要求，则退出还原现场
 * 用col数组记录已经被"占领"的列，用main用来记录已经被"占领"的主对角线，用sub用来记录已经被"占用"的副对角线
 *
 */
@Slf4j
public class SolveNQueens {

    /**
     * 已经被"占领"的列
     */
    private boolean[] col;
    /**
     * 已经被"占领"的主对角线: 横坐标 - 纵坐标 = 固定的值
     */
    private boolean[] main;
    /**
     * 已经被"占用"的副对角线: 横坐标 + 纵坐标 = 固定的值
     *
     */
    private boolean[] sub;

    private int n;

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return res;
        }
        this.n = n;
        col = new boolean[n];
        main = new boolean[2 * n - 1];
        sub = new boolean[2 * n - 1];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    public void dfs(int row, Deque<Integer> path){
        if(row == n){
            //表示已经找到（一种）结果
            res.add(convert(path));
            return;
        }
        for(int j = 0; j < n; j++){
            //main数组中"+ n - 1"是为了防止下标为负数
            if(!col[j] && !main[row - j + n - 1] && !sub[row + j]){
                path.addLast(j);
                col[j] = true;
                main[row - j + n - 1] = true;
                sub[row + j] = true;
                dfs(row + 1, path);
                //dfs后还完现场（即把上一步下的棋子拿走，下另外一部去尝试其他情况）
                col[j] = false;
                main[row - j + n - 1] = false;
                sub[row + j] = false;
                path.removeLast();
            }
        }
    }

    public List<String> convert(Deque<Integer> path){
        List<String> board = new ArrayList<>();
        for(Integer num : path){
            StringBuilder row = new StringBuilder();
            for(int i = 0; i < num; i++){
                row.append(".");
            }
            row.append("Q");
            for (int j = num + 1; j < this.n; j++){
                row.append(".");
            }
            board.add(row.toString());
        }
        return board;
    }

    @Test
    public void test1(){
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> lists = solveNQueens.solveNQueens(4);
        log.info("lists={}", lists);
    }

    @Test
    public void test2(){
        SolveNQueens solveNQueens = new SolveNQueens();
        solveNQueens.n = 5;
        Deque<Integer> path = new ArrayDeque<>();
        path.addLast(2);
        path.addLast(4);
        path.addLast(0);
        List<String> convert = solveNQueens.convert(path);
        log.info("convert={}", convert);
    }
}
