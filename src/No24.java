public class No24 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        if (head == null)
            return null;
        dummy.next = head;
        ListNode pre, left, right, next;
        pre = dummy;
        left = head;
        right = head.next;
        if (right == null)
            return head;
        else
            next = right.next;

        while (true) {
            pre.next = right;
            right.next = left;
            left.next = next;
            if (next == null)
                break;
            else {
                pre = pre.next.next;
                left = pre.next;
                right = left.next;
                if (right == null)
                    break;
                else
                    next = right.next;
            }
        }
        return dummy.next;
    }
}
