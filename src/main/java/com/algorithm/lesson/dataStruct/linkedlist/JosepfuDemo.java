package com.algorithm.lesson.dataStruct.linkedlist;

/**
 *
 * Josephu
 * 问题为：设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，
 * 数到m 的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，
 * 依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 *
 * 约瑟夫问题
 *
 * @author yangqian
 * @date 2021/1/16
 */
public class JosepfuDemo {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        System.out.println("========================================");

        // 生成小孩的出圈顺序
        circleSingleLinkedList.countBoy(1, 2,5);
    }

}

/**
 * 创建一个环形的单向链表
 */
class CircleSingleLinkedList {
    /**
     * 创建一个first节点, 当前没有编号
     */
    private Boy first = new Boy(-1);
    /**
     * 添加节点，构建一个环形链表
     */
    public void addBoy(int nums) {
        // 至少一个小孩
        if (nums < 1) {
            System.out.println("nums 值不准确");
            return;
        }
        Boy curBoy = null;
        // 使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                // 第一个小孩
                first = boy;
                // 指向第一个，构成环状
                first.setNext(boy);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                // 指向第一个，构成环状
                boy.setNext(first);
                // 当前节点更新指向
                curBoy = boy;
            }
        }
    }

    /**
     *  遍历当前的环形列表
     */
    public void showBoy() {
        // 判断当前列表是否为空
        if (first == null) {
            System.out.println("没有任何小孩 ~");
            return;
        }
        // 因为first不能移动，所以使用一个curBoy指针
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                // 遍历完成
                break;
            }
            curBoy = curBoy.getNext();
        }
    }


    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     * startNo 开始的位置
     * countNum 数几下
     * nums 小孩总数
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        // 1、找到辅助节点(first前一个节点)
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        // 2、移动到第一个小孩的位置
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 3、当小孩报数的时候，让 first 和 helper开始移动m-1次，然后出圈
        // 圈中只有一个人
        while (helper != first) {
            // 让 first 和 helper 指针同时移动到 countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这个时候first指向的小孩出圈
            System.out.printf("出圈的小孩 NO.[%d]\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩 NO.[%d]\n", first.getNo());
    }

}

/**
 * 创建一个Boy类
 * 后续算法解题思路: 将实体类对象模拟为一个节点
 */
class Boy {
    /**
     * 编号
     */
    private int no;
    /**
     * 指向下一个节点，默认为null
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
