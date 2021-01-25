package com.algorithm.lesson.dataStruct.linkedlist;

import java.util.Stack;

/**
 * 单向链表
 *  => 顺序添加, 删除节点, 倒数第K个元素
 *
 * @author yangqian
 * @date 2021/1/15
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 正常加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        // 按照顺序加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        System.out.println("原来的链表的情况~~");
        singleLinkedList.list();

        HeroNode newHeroNode = new HeroNode(2, "卢俊义-update", "玉麒麟 ~~");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改后链表的情况~~");
        singleLinkedList.list();

        singleLinkedList.delete(hero1);
        singleLinkedList.delete(hero4);
        System.out.println("删除后链表的情况~~");
        singleLinkedList.list();

        System.out.printf("链表长度:[%d]", getLength(SingleLinkedList.head));

        System.out.println();

        System.out.printf("倒数第k个元素:[%s]", findLastIndexNode(SingleLinkedList.head, 1));

        System.out.println();

//        reverseHead(SingleLinkedList.head);

//        singleLinkedList.list();

        reversePrint(SingleLinkedList.head);


    }

    /**
     * 题目1: 获取单链表的节点个数（如果带有头节点的链表，需求不统计头节点）
     * @param head
     * @return
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            // 空链表
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length ++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 题目2: 查询倒数第k个节点
     * 编写一个方法，接收head节点，同时接收一个index
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        // 第一次获取长度
        int size = getLength(head);
        // 获取倒数第k个节点
        if (index <= 0 || index > size) {
            return null;
        }
        // 定义一个辅助变量 for 循环定位倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 题目3: 单链表的反转
     */
    public static void reverseHead(HeroNode head) {
        if (head.next == null) {
            return;
        }
        HeroNode cur = head.next;
        // 指向当前节点的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            // 连接到新的链表上
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 题目4: 逆序打印链表
     * 1) 反转再打印 （破坏了原来的结构，不建议使用）
     * 2) 将各个节点压入栈中，利用栈的先进后出的特点，达到逆序的效果
     */
    public static void reversePrint(HeroNode headNode) {
        if (headNode.next == null) {
            return;
        }
        // 创建栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = headNode.next;
        // 将链表的节点压入栈中
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 将栈中节点进行打印，pop出栈
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}

/**
 * 定义SingleLinkedList管理我们的英雄
 */
class SingleLinkedList {
    /**
     * 先初始化头节点，先保证头节点不要动
     * 不存放具体的数据
     */
    public static HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加一个节点
     * 思路：当不考虑编号的顺序的时候
     * 1、找到当前链表的最后节点
     * 2、将最后的这个节点的next指向新的节点
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (temp.next != null) {
            // 找到了链表的最后一个节点
            // 如果没有找到最后，则直接将节点后移即可
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 根据编号修改节点
     * 1. 根据newHeroNode的no来进行修改
     */
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空 ~");
            return;
        }
        // 找到需要修改的节点，根据no编写
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                // 找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            // 没有找到
            System.out.println("没有找到需要修改的节点");
        }
    }

    /**
     * 删除节点
     */
    public void delete(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            System.out.println("删除成功");
        }
    }

    /**
     * 展示链表中的数据列表[遍历]
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println(temp);
    }

    /**
     * 第二种方式在添加英雄的时候，根据排名添加到指定位置
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        // 标志添加的编号是否存在，默认false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                // 说明temp在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                // 找temp下一个位置的值与需要添加的值进行比较
                // 在temp的后面进行添加
                break;
            } else if (temp.next.no == head.no) {
                // 说明编号存在
                flag = true;
                break;
            }
            // 后移，用于遍历当前的链表
            temp = temp.next;
        }
        if (flag) {
            System.out.println("准备插入的英雄编号已经存在不能够加入");
        } else {
            // 插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
            System.out.println("添加成功");
        }
    }
}

/**
 * 节点的单独定义
 * 每个HeroNode对象就是一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    /**
     * 指向下一个节点
     */
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{no=" + no + ", name='" + name + '\'' + ", nickName='" + nickName + '}';
    }
}
