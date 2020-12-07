package com.wxweven.algorithm.btree.BST;

import com.wxweven.algorithm.btree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class BST2双向链表 {
    TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        dfs(root);

        // 进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
        head.left = pre;
        pre.right = head;

        return head;
    }

    void dfs(TreeNode cur) {
        // 边界条件
        if (cur == null) {
            return;
        }

        // 中序遍历，先遍历左节点
        dfs(cur.left);

        // pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,
        // 当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        if (pre == null) {
            head = cur;
        } else {
            // 反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
            pre.right = cur;
        }

        // pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。
        cur.left = pre;

        // pre往后移
        pre = cur;

        // 中序遍历，后遍历右节点
        dfs(cur.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode head = treeToDoublyList(root);

        Assert.assertEquals(1, (int) head.val);
        Assert.assertEquals(3, (int) head.left.val);
        Assert.assertEquals(2, (int) head.right.val);
    }
}
