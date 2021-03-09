package com.labuladong.chapter2;

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
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
}
