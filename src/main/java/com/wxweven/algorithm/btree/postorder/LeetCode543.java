package com.wxweven.algorithm.btree.postorder;

import com.wxweven.algorithm.btree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 求二叉树的直径（即最远的任意两个节点之间的距离）
 *
 * same method with 124,687 and 543
 */
public class LeetCode543 {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 先处理左节点
        int left = helper(root.left);
        // 再处理右节点
        int right = helper(root.right);

        // 处理最终结果
        left = root.left == null ? 0 : left + 1;
        right = root.right == null ? 0 : right + 1;

        res = Math.max(res, left + right);

        // 递归函数的返回值
        return Math.max(left, right);
    }

    @Test
    public void test() {
        TreeNode root = TreeNode.initTree();

        int longestPath = diameterOfBinaryTree(root);
        System.out.println(longestPath);

        Assert.assertEquals(5, longestPath);
    }
}
