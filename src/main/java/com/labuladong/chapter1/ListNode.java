package com.labuladong.chapter1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangqian
 * @date 2021/3/8
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
