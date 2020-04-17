package base;

public class No86 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode beforeTail = before, afterTail = after;

        while (head != null) {
            if (head.val < x) {
                beforeTail.next = head;
                beforeTail = head;
            } else if (head.val >= x) {
                afterTail.next = head;
                afterTail = head;
            }
            head = head.next;
        }
        beforeTail.next = after.next;
        afterTail.next = null;
        return before.next;
    }
}
