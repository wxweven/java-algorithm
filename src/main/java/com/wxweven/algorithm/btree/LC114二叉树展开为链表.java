package com.wxweven.algorithm.btree;

public class LC114二叉树展开为链表 {

    /*
     * 讲解参见：https://www.yuque.com/wxweven/yn3rzz/yt3wzn
     * 将二叉树按照先序遍历方式转化成链表
     *
     * IGiven a binary tree, flatten it to a linked list in-place.
     *
     * For example, given the following tree:
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * The flattened tree should look like:
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     */

    public void convert(TreeNode root) {

        if (root == null) {
            return;
        }

        convert(root.left);
        convert(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        p.right = right;
    }
}
