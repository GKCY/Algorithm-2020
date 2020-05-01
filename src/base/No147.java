package base;

import DS.ListNode;

public class No147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode node = head;
            head = head.next;

            ListNode cur = dummy;
            while (cur.next != null) {
                if (cur.next.val > node.val)
                    break;
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return dummy.next;
    }
}
