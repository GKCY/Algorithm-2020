package base;

import DS.ListNode;

public class No203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return removeElements(head.next, val);
        else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }

    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (head != null) {
            if (head.val != val) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
