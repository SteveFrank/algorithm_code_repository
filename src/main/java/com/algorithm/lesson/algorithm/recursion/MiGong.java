package com.algorithm.lesson.algorithm.recursion;

/**
 * @author yangqian
 * @date 2021/1/25
 */
public class MiGong {

    public static void main(String[] args) {
        // 先创建一个迷宫，模拟迷宫
        int[][] map = new int[8][7];
        // 使用1表示墙
        // 将上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 将左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("*****************************");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*****************************");
        setWay(map, 1, 1);
        System.out.println("走过的路线标记如下:");
        System.out.println("=============================");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=============================");

    }

    /**
     * 1、map作为地图
     * 2、i，j 标识从地图的那个位置开始出发(1,1)
     * 3、如果小球能够到 map[6][5] 的位置，则说明通路可以找到
     * 4、约定: 当 map[i][j]
     *  为0标识该点没有走过，
     *  当为1的时候标识墙;
     *  2表示通路可以走;
     *  3表示该店已经走过，但是没有走通
     * 5、在走迷宫的时候，定下一个策略 下 -> 右 -> 上 -> 左 如果该店走不通，再回溯
     *
     * 给小球找路
     * @param map 地图
     * @param i 从哪个位置开始 坐标 x
     * @param j 从哪个位置开始 坐标 y
     * @return 寻找通路 正常返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            // 通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                // 假定该点可以走通
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
