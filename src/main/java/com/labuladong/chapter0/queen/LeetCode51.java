package com.labuladong.chapter0.queen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * N皇后问题
 *
 * @author yangqian
 * @date 2021/3/15
 */
public class LeetCode51 {

    public static void main(String[] args) {

    }


    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        return null;
    }

    /**
     * 路径：board中小于row的那些行都已经成功放置了皇后
     * 选择列表：第 row 行的所有列都是放置皇后的选择
     * 结束条件：row 超过board的最后一行
     * @param board
     * @param row
     */
    public void backtrack(List<List<String>> board, int row) {
        // 触发结束条件
        if (row == board.size()) {
            res.add(board.get(row));
        }
    }

    /**
     * 首先确认判断valid函数
     * @param board
     * @param row
     * @param col
     * @return
     */
    boolean isValid(List<List<String>> board, int row, int col) {
        int n = board.size();
        // 检查列 是否有皇后互相冲突
        for (List<String> strings : board) {
            if ("Q".equalsIgnoreCase(strings.get(col))) {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if ("Q".equalsIgnoreCase(board.get(i).get(j))) {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equalsIgnoreCase(board.get(i).get(j))) {
                return false;
            }
        }
        return true;
    }

}
