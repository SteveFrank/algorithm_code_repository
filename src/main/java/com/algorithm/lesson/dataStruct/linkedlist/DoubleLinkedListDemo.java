package com.algorithm.lesson.dataStruct.linkedlist;

/**
 *
 * 双向链表
 *
 * @author yangqian
 * @date 2021/1/15
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroDoubleNode hero1 = new HeroDoubleNode(1, "宋江", "及时雨");
        HeroDoubleNode hero2 = new HeroDoubleNode(2, "卢俊义", "玉麒麟");
        HeroDoubleNode hero3 = new HeroDoubleNode(3, "吴用", "智多星");
        HeroDoubleNode hero4 = new HeroDoubleNode(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        // 按照顺序加入
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);

        doubleLinkedList.list();
    }

}

/**
 * 定义SingleLinkedList管理我们的英雄
 */
class DoubleLinkedList {
    /**
     * 先初始化头节点，先保证头节点不要动
     * 不存放具体的数据
     */
    public static HeroDoubleNode head = new HeroDoubleNode(0, "", "");

    /**
     * 添加一个节点
     */
    public void add(HeroDoubleNode heroNode) {
        HeroDoubleNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后，则将temp后移
            temp = temp.next;
        }
        // 形成双线链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 根据编号修改节点
     * 1. 根据newHeroNode的no来进行修改
     */
    public void update(HeroDoubleNode newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空 ~");
            return;
        }
        // 找到需要修改的节点，根据no编写
        HeroDoubleNode temp = head.next;
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
    public void delete(HeroDoubleNode node) {
        if (head.next == null) {
            System.out.println("链表为空, 无法删除");
            return;
        }
        HeroDoubleNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            // temp后移，遍历
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
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
        HeroDoubleNode temp = head;
        while (temp.next != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println(temp);
    }

    /**
     * 按照顺序添加
     * @param heroNode
     */
    public void addByOrder(HeroDoubleNode heroNode) {
        HeroDoubleNode temp = head;
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
            if (temp.next != null) {
                temp.next.pre = heroNode;
            }
            temp.next = heroNode;
            System.out.println("添加成功");
        }
    }
}

/**
 * 节点的单独定义
 * 每个HeroNode对象就是一个节点
 * 双向链表节点
 */
class HeroDoubleNode {
    public int no;
    public String name;
    public String nickName;
    /**
     * 指向下一个节点
     */
    public HeroDoubleNode next;
    /**
     * 指向上一个节点
     */
    public HeroDoubleNode pre;

    public HeroDoubleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{no=" + no + ", name='" + name + '\'' + ", nickName='" + nickName + '}';
    }
}
