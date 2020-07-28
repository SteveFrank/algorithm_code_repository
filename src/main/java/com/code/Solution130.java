package com.code;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 *
 */
public class Solution130 {

    /**
     * 二维数据共有多少行
     */
    private int m;
    /**
     * 二维数组共有多少列
     */
    private int n;
    /**
     * 目标二维数组
     */
    private char[][] board;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    for (int ii = i; ii < m; ii++) {
                        for (int jj = j; jj < n; jj ++) {
                            if (board[ii][jj] == 'X') {

                            }
                        }
                    }
                }
            }
        }
    }


    private boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    public static void main(String[] args) {

    }

}
