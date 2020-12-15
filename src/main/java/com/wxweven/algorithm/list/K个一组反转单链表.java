package com.wxweven.algorithm.list;

/**
 * @author wxweven
 */
public class K个一组反转单链表 {

    /*
     * 1 -> 2 -> 3 -> 4 -> 5, k=2
     * 反转后：
     * 2 -> 1 -> 4 -> 3 -> 5
     */
    public ListNode reverseGroup(ListNode head, int k) {
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }

            b = b.next;
        }

        ListNode newHead = reverse(a, b);
        a.next = reverseGroup(b, k);

        return newHead;
    }

    /**
     * 反转 [a, b) 之间的node
     */
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null;
        ListNode nxt;
        ListNode cur = a;

        while (cur != b) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }

        return prev;
    }
}