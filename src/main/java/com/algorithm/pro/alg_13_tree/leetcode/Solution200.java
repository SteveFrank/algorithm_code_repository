package com.algorithm.pro.alg_13_tree.leetcode;

/**
 * @author frankq
 * @date 2022/1/25
 */
public class Solution200 {
    /**
     * 定义定点向: 上下左右，各走一步的方向信息
     */
    int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    /**
     * 定义网格的行数
     */
    int rows;
    /**
     * 定义网格的列数
     */
    int clos;

    public int numIslands(char[][] grid) {
        // 定义岛屿总数
        int count = 0;
        // 获取网格有多少行
        rows = grid.length;
        if (rows == 0) {
            return count;
        }
        // 获取网络有多少列
        clos = grid[0].length;
        // 定义网格各个顶点是否被访问过
        boolean[][] visited = new boolean[rows][clos];
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < clos; j ++) {
                // 如果是陆地，并且没有被访问过则深度优先搜索(i, j)顶点相连的陆地
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, visited, grid);
                    // 找到一块count + 1
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 搜索与(x, y)相连的陆地定点，并且标记这些顶点
     */
    public void dfs(int x, int y, boolean[][] visited, char[][] grid) {
        // 走过的点需要进行标记
        visited[x][y] = true;
        // 从该顶点，向上下左右四个方向试探
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (inGrad(newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                dfs(newX, newY, visited, grid);
            }
        }
    }

    public boolean inGrad(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < clos;
    }

    public static void main(String[] args) {

    }

}
