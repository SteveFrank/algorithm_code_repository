package com.algorithm.lesson.dataStruct.linkedlist;

/**
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

        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        System.out.println("原来链表的情况~~");
        singleLinkedList.list();
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
    private HeroNode head = new HeroNode(0, "", "");

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
