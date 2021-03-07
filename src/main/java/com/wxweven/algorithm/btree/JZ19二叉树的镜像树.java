package com.wxweven.algorithm.btree;


/*
 * 面试题19：二叉树的镜像(递归和非递归)
 */
public class JZ19二叉树的镜像树 {
    //递归，先交换结点的左右子结点，然后递归调用左右子结点。

    public void mirrorRecursively(TreeNode tree) {
        if (tree == null) {
            return;
        }

        TreeNode temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        if (tree.left != null) mirrorRecursively(tree.left);
        if (tree.right != null) mirrorRecursively(tree.right);
    }
}
