package com.wxweven.algorithm.btree.depth;

import com.wxweven.algorithm.btree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wxweven
 * @date 2018/10/27
 */
public class DepthOfBTree {

    /**
     * 递归求解树的深度
     *
     * @param root 根节点
     * @return
     */
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);//求左子树的深度
        int rightDepth = getDepth(root.right);//求右子树的深度

        // 左子树和右子树深度较大的那个加一等于整个树的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 求树的深度，非递归实现
     * 利用层次遍历
     *
     * @param root 根节点
     * @return
     */
    public int getDeep2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode current;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            //每遍历完一层depth+1
            depth++;
        }

        return depth;
    }

    @Test
    public void getDepthTest() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        TreeNode.setSubTree(node1, node2, node3);
        TreeNode.setSubTree(node2, node4, node5);
        TreeNode.setSubTree(node3, null, node6);
        TreeNode.setSubTree(node5, node7, node8);
        TreeNode.setSubTree(node6, node9, null);

        int biTreeDepth = getDepth(node1);
        int biTreeDepth2 = getDeep2(node1);
        System.out.println("树的深度：" + biTreeDepth);
        System.out.println("树的深度：" + biTreeDepth2);
        Assert.assertEquals(4, biTreeDepth);
        Assert.assertEquals(4, biTreeDepth2);

    }
}
