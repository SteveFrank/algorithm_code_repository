package com.code;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 *
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 *
 */
public class Solution289 {

    /**
     * 四个方位信息
     */
    private int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    /**
     * 二维数据共有多少行
     */
    private int m;
    /**
     * 二维数组共有多少列
     */
    private int n;

    private int[][] board;

    public void gameOfLife(int[][] board) {
        m = board.length;
        if (m != 0) {
            n = board[0].length;
            this.board = board;
            // 构建标记的二维数组 false 维持原值，true 翻转变化
            int[][] marked = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    marked[i][j] = dfs(i, j, board[i][j]);
                }
            }
            for (int i = 0; i < m; i++) {
                if (n >= 0) {
                    System.arraycopy(marked[i], 0, board[i], 0, n);
                }
            }
        }
    }

    private int dfs(int i, int j, int boardValue) {
        int live = 0;
        for (int k = 0; k < 8; k ++) {
            int newX = i + direction[k][0];
            int newY = j + direction[k][1];
            if (isArea(newX, newY)) {
                if (board[newX][newY] == 1) {
                    live ++;
                }
            }
        }
        if (boardValue == 1) {
            if (live < 2 || live > 3) {
                return 0;
            }
        } else {
            if (live == 3) {
                return 1;
            }
        }
        return boardValue;
    }


    private boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {

    }

}
