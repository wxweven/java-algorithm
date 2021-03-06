package com.wxweven.algorithm.list.fastslow;

import com.wxweven.algorithm.list.ListNode;

/**
 * @author wxweven
 */
public class 链表中点 {

    public ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}