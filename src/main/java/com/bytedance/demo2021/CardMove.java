package com.bytedance.demo2021;


import java.util.LinkedList;

/**
 * TODO 我手中有一堆扑克牌， 但是观众不知道它的顺序。
 *
 * 1、第一步， 我从牌顶拿出一张牌， 放到桌子上。
 *
 * 2、第二步， 我从牌顶再拿一张牌， 放在手上牌的底部。
 *
 * 3、第三步， 重复第一步、第二步的操作， 直到我手中所有的牌都放到了桌子上。
 *
 * 最后， 可以看到桌子上牌的顺序是：(牌底部）1,2,3,4,5,6,7,8,9,10,11,12,13 (牌顶部）
 *
 * 问， 刚开始拿在手里的牌的顺序是什么？
 *
 * @author yangqian
 * @date 2021/3/9
 */
public class CardMove {

    public static void main(String[] args) {
        CardMove cardMove = new CardMove();
        System.out.println(cardMove.listNode("1,2,3,4,5,6,7,8,9,10,11,12,13"));
    }

    public String listNode(String cardNow) {

        String[] cardArray = cardNow.split(",");

        if (cardArray.length == 0) {
            return "";
        }

        LinkedList<String> cardBefore = new LinkedList<>();

        // 最后一个动作一定是把牌放在桌上
        int length = cardArray.length - 1;
        int index = 0;
        while (index <= cardArray.length - 1) {
            String now = cardArray[length];
            if (index % 2 == 0) {
                cardBefore.addFirst(now);
            } else {
                cardBefore.addLast(now);
            }
            index ++;
            length --;
        }


        return cardBefore.toString();
    }

}
