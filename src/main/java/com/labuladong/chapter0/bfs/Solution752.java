package com.labuladong.chapter0.bfs;

import java.util.*;

/**
 * 转盘解锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。
 * 每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。
 * 每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * @author yangqian
 * @date 2021/4/1
 */
public class Solution752 {

    public static void main(String[] args) {

    }

    public int openLockDoubleBfs(String[] deadends, String target) {
        // 将错误终止的密码放入Set集合中
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        // 使用集合的方式，进行快速判断
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希结合在遍历的时候不能够进行修改，使用temp暂存
            Set<String> temp = new HashSet<>();
            // 将 q1 中的所有节点向周围扩散
            for (String current : q1) {
                if (deads.contains(current)) {
                    continue;
                }
                if (q2.contains(current)) {
                    return step;
                }
                visited.add(current);

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(current, j);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(current, j);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step ++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    /**
     * 开锁算法 单向BFS方式 可以看到单向的BFS方式虽然没有双向BFS快，但是不必须知道终点在哪
     * 双向BFS必须要知道终点在哪
     * @param deadends 死亡数字
     * @param target   目标数字
     * @return
     */
    public int openLock(String[] deadends, String target) {
        // 将错误终止的密码放入Set集合中
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        // 记录已经穷举了的密码
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        // 放置起点数据
        queue.offer("0000");
        // 避免重复放置
        visited.add("0000");

        int step = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            // 将当前队列中的所有节点向周围扩散
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                // 判断是否到达了终点
                if (deads.contains(current)) {
                    continue;
                }
                if (current.equalsIgnoreCase(target)) {
                    return step;
                }

                // 将为遍历的节点加入到队列中
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(current, j);
                    if (!visited.contains(up)) {
                        // 没有遍历过该节点加入队列汇总
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(current, j);
                    if (!visited.contains(down)) {
                        // 没有遍历过该节点加入队列汇总
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            // 增加步数
            step ++;
        }
        return -1;
    }

    void BFS(String target) {
        // 根据BFS框架打印出所有的密码
        Queue<String> queue = new LinkedList<>();
        // 设置初始密码
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 将当前队列中的所有节点想周围扩散
                String current = queue.poll();
                System.out.println(current);
                // 判断是否到达了终点
                for (int j = 0; j < 4; j ++) {
                    String up = plusOne(current, j);
                    String down = minusOne(current, j);
                    queue.offer(up);
                    queue.offer(down);
                }
            }
        }
        return;
    }

    /**
     * 将 s[j] 向上拨动一次
     */
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    /**
     * 将 s[j] 向下拨动一次
     */
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }


}
