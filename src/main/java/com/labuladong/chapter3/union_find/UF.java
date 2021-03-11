package com.labuladong.chapter3.union_find;

/**
 * @author yangqian
 * @date 2021/3/10
 */
public class UF {
    /**
     * 记录连通分量
     */
    private int count;
    /**
     * 节点 x 的节点是 parent[x]
     */
    private int[] parent;

    public UF(int n) {
        // 如果一开始互不连通
        this.count = n;
        // 父节点指针始终会指向自己
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
}
