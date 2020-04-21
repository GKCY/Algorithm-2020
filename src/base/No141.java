package base;

import DS.ListNode;

public class No141 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2)
                return true;
        }
        return false;
    }
}
