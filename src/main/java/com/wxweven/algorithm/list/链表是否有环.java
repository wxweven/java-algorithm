package com.wxweven.algorithm.list;

/**
 * @author wxweven
 */
public class 链表是否有环 {

    /**
     * 思路：
     * 快慢指针法：快指针每次走2步，慢指针每次走1步，如果链表有环，则快慢指针最终会相遇
     *
     * @param head
     * @return
     */
    public static boolean hasCircle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 边界条件：快指针还能继续往下走
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // 快慢指针相遇，说明有环
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}