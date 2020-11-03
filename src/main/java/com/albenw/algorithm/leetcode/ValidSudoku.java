package com.albenw.algorithm.leetcode;

import java.util.HashMap;

/**
 * @author alben.wong
 * @since 2020/10/10.
 * leetcode 36 有效的数独，验证已经填入的数字是否有效即可
 *
 *
 */
public class ValidSudoku {

    private HashMap<Integer, Integer>[] rows = new HashMap[9];
    private HashMap<Integer, Integer>[] cols = new HashMap[9];
    private HashMap<Integer, Integer>[] block = new HashMap[9];

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            block[i] = new HashMap<>();
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                char x = board[i][j];
                if(x == '.'){
                    continue;
                }
                Integer num = Integer.valueOf(x);
                int box_index = (i / 3 ) * 3 + j / 3;
                rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                cols[j].put(num, cols[j].getOrDefault(num, 0) + 1);
                block[box_index].put(num, block[box_index].getOrDefault(num, 0) + 1);

                if (rows[i].get(num) > 1 || cols[j].get(num) > 1 || block[box_index].get(num) > 1){
                    return false;
                }
            }
        }
        return true;
    }

}
