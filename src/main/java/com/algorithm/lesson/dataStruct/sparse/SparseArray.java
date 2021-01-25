package com.algorithm.lesson.dataStruct.sparse;

/**
 * 数组
 *  => 二维数组
 * 稀疏数组
 *  => 压缩与还原
 *
 * @author yangqian
 * @date 2021/1/15
 */
public class SparseArray {

    public static void main(String[] args) {

        // 创建一个原始的二维数组 11 * 11
        // 0：标识没有棋子，1：表示黑子，2：标识白字

        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;

        // 输出原始二维数组
        System.out.println("1、输出原始二维数组 : ");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转稀疏数组的思路
        // 1、先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data > 0) {
                    sum ++;
                }
            }
        }
        System.out.println();
        System.out.printf("2、非零总数为 : %d\n", sum);

        // 2、创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组赋值
        // 第一行：基础信息，多少行多少列，多少非0的值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 第二行：存储非0的值
        // 用于记录是第几个非0的数据
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] > 0) {
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("3、得到的稀疏数组为:");
        for (int[] value : sparseArr) {
            System.out.printf("%d\t%d\t%d\t", value[0], value[1], value[2]);
            System.out.println();
        }
        System.out.println();

        //将稀疏数组 --》 恢复成 原始的二维数组
		/*
		 *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
			2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
		 */

        // 1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2、在读取稀疏数组后几行的数据赋值给原数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        // 输出还原后的数组
        System.out.println("4、还原后的数组:");
        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println();

    }

}
