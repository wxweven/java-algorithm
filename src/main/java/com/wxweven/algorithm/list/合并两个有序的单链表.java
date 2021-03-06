package com.wxweven.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class 合并两个有序的单链表 {

    /*
     * 面试题17：合并两个排序的链表(递归)
     * 输入两个递增的链表，合并这两个链表并使新链表仍然是递增的。
     * 思路：递归。
     * 每次比较两个链表的第一个结点，提出小的，
     * 然后将它的next和剩下的继续合并
     * 它的next等于递归返回值。
     */
    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode newHead = null;
        if (head1.val < head2.val) {
            newHead = head1;
            newHead.next = merge(head1.next, head2);
        } else {
            newHead = head2;
            newHead.next = merge(head2.next, head1);
        }

        return newHead;
    }

    /**
     * 合并两个有序的单链表（非递归方式）
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode();
        ListNode result = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prehead.next = l1;
                l1 = l1.next;
            } else {
                prehead.next = l2;
                l2 = l2.next;
            }
            prehead = prehead.next;
        }

        if (l1 != null) {
            prehead.next = l1;
        }
        if (l2 != null) {
            prehead.next = l2;
        }

        return result.next;
    }

    @Test
    public void test() {
        ListNode head1 = ListNode.createLinkedList(Arrays.asList(1, 3, 5, 7));
        ListNode head2 = ListNode.createLinkedList(Arrays.asList(2, 4, 6, 8));

        ListNode newHead = merge(head1, head2);
        System.out.println("递归合并后链表：");
        ListNode.print(newHead);
        Assert.assertEquals(newHead.val, 1);
        Assert.assertEquals(newHead.next.val, 2);

        ListNode head3 = ListNode.createLinkedList(Arrays.asList(1, 3, 5, 7));
        ListNode head4 = ListNode.createLinkedList(Arrays.asList(2, 4, 6, 8));
        ListNode newHead2 = mergeTwoLists(head3, head4);
        System.out.println("非递归合并后链表：");
        ListNode.print(newHead2);

        Assert.assertEquals(newHead2.val, 1);
        Assert.assertEquals(newHead2.next.val, 2);
    }
}



