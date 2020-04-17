package base;

import java.util.PriorityQueue;

public class No23 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null)
                pq.add(node.next);
            tail.next = node;
            tail = node;
        }
        tail.next = null;
        return head.next;
    }
}
