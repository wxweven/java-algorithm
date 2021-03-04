package com.wxweven.algorithm.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class 反转单链表 {

    ListNode successor = null;

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    // 递归方式：图解 https://www.yuque.com/wxweven/yn3rzz/1607663560360
    public static ListNode reverseV2(ListNode head) {

        /*如果是空链或者只是单个节点的链表  将直接返回*/
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverse = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    /**
     * 反向打印链表
     */
    public static void reversePrint(ListNode head) {
        if (head == null) {
            return;
        }

        reversePrint(head.next);
        System.out.print(head.val + "->");
    }

    /**
     * 迭代法，反转前N个节点
     */
    public ListNode reverseN(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        ListNode next;

        while (n > 1) {
            next = head.next;
            head.next = next.next;
            next.next = prev.next;
            prev.next = next;

            n--;
        }

        return dummy.next;

    }

    /**
     * 递归反转前N个节点
     */
    public ListNode reverseNV2(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseNV2(head.next, n - 1);
        head.next.next = head;
        head.next = successor;

        return last;
    }

    /*
     * 迭代方式，反转 [m, n] 之间的节点
     * 这个问题，可以转化为上述的 反转前 N 个节点：
     * 让 head 往后移动到第 m 个节点，然后反转以第 m 个节点为首的前 N 个节点
     * 注意，这里的 N 不再是输入的 n，而是 n - m。
     * 怎么理解：
     * 举例，链表为：1 -> 2 -> 3 -> 4 -> 5 -> 6, 反转 [2, 4]
     * 即最终变为：1 -> 4 -> 3 -> 2 -> 5 -> 6
     *
     * 刚开始，head 在1， left 相对于 head 的步长为m，right相对于head的步长为n
     * 这时候 head 在m, left 相对于 head 的步长就变为了0，right相对于head的步长为n-m
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (m > 1) {
            prev = prev.next;
            m--;

            /*
             * 保持相对步长不变，这里 n 也要 --
             * 换句话说，如果 m--，而 n 不变，那反转的节点个数就不对了
             */
            n--;
        }

        head = prev.next;
        ListNode next;

        while (n > 1) {
            next = head.next;
            head.next = next.next;
            next.next = prev.next;
            prev.next = next;

            n--;
        }

        return dummy.next;
    }

    /**
     * 递归版算法
     */
    public ListNode reverseBetweenV2(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseNV2(head, n);
        }

        /*
         * 反转以 head.next 为首的区间节点
         * 对于head.next 来说，原来的步长 [m, n] 就变成了 [m-1, n-1]
         */
        head.next = reverseBetweenV2(head.next, m - 1, n - 1);

        return head;
    }

    @Test
    public void test() {
        ListNode head = ListNode.createLinkedList(Arrays.asList(5));
        System.out.println("原链表：");
        ListNode.print(head);

        ListNode newHead = reverse(head);

        System.out.println("反转后链表：");
        ListNode.print(newHead);

        Assert.assertEquals(5, newHead.val);

        System.out.println();

        head = ListNode.createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("原链表：");
        ListNode.print(head);

        System.out.println("逆序输出：");
        reversePrint(head);
        System.out.println();

        newHead = reverseV2(head);

        System.out.println("反转后链表：");
        ListNode.print(newHead);
        Assert.assertEquals(5, newHead.val);
    }
}
