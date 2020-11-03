package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/25.
 * leetcode 200. 岛屿数量
 * 使用并查集
 */
@Slf4j
public class NumIslands {

    public int numIslands(char[][] grid) {
        return 0;
    }

    @Test
    public void test(){
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        int i = numIslands.numIslands(grid);
        log.info("i={}", i);
    }
}
