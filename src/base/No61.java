package base;

public class No61 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        tail.next = head;
        // 旋转k个位置，就是从tail后第size-k%size后面切开环
        k = size - k % size;
        ListNode p = tail;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        ListNode res = p.next;
        p.next = null;
        return res;
    }
}
