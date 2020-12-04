package com.wxweven.algorithm.btree.BST;

import com.wxweven.algorithm.btree.TreeNode;
import com.wxweven.algorithm.btree.levelorder.二叉树层次遍历;
import org.junit.Test;


/**
 * @author wxweven
 * @date 2020/12/2
 */
public class BST插入元素 {

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.val) {
            root.left = insert(root.left, data);
        } else if (data > root.val) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    @Test
    public void testDeleteData() {
        TreeNode root = TreeNode.getBSTTree();
        二叉树层次遍历.travelByLevel(root);

        TreeNode root2 = insert(root, 14);
        System.out.println();

        二叉树层次遍历.travelByLevel(root2);
    }
}
