package base;

import DS.ListNode;

public class No25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode tail = head;
        int count = 1;
        while (tail.next != null && count < k) {
            tail = tail.next;
            count++;
        }

        if (count < k)
            return head;

        ListNode newHead = reverseKGroup(tail.next, k);
        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
