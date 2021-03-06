package com.wxweven.algorithm.btree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class 二叉树公共父节点 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        parent.put(root, null);
        queue.offer(root);

        // 循环终止的条件：p和q的父节点都已在map中
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode curNode = queue.poll();
            if (curNode.left != null) {
                parent.put(curNode.left, curNode);
                queue.offer(curNode.left);
            }

            if (curNode.right != null) {
                parent.put(curNode.right, curNode);
                queue.offer(curNode.right);
            }
        }

        Set<TreeNode> pParents = new HashSet<>();
        while (p != null) {
            // 自己也要加到自己的parent数组中，不然q是p的子节点的时候，就错了
            pParents.add(p);
            p = parent.get(p);
        }

        while (!pParents.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
