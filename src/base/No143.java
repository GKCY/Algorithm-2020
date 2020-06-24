package base;

import DS.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class No143 {
    public void reorderList1(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode cur = head;
        while (cur.next.next != null)
            cur = cur.next;
        if (cur == head)
            return;
        cur.next.next = head.next;
        head.next = cur.next;
        cur.next = null;
        reorderList1(head.next.next);
    }

    public void reorderList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        Deque<ListNode> deque = new LinkedList<>();
        while (head != null) {
            deque.offerLast(head);
            head = head.next;
        }

        ListNode tail = dummy;
        boolean first = true;
        while (!deque.isEmpty()) {
            if (first)
                tail.next = deque.pollFirst();
            else
                tail.next = deque.pollLast();
            tail = tail.next;
            first = !first;
        }
        tail.next = null;
    }

    public void reorderList3(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode newHead = null;
        while (mid != null) {
            ListNode tmp = mid.next;
            mid.next = newHead;
            newHead = mid;
            mid = tmp;
        }

        boolean first = true;
        ListNode pre = null;
        while (head != null && newHead != null) {
            if (pre == null) {
                pre = head;
                head = head.next;
            } else if (first) {
                pre.next = head;
                pre = head;
                head = head.next;
            } else if (!first) {
                pre.next = newHead;
                pre = newHead;
                newHead = newHead.next;
            }
            first = !first;
        }
        if (head != null)
            pre.next = head;
        if (newHead != null)
            pre.next = newHead;
    }

    public void reorderList4(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        int length = 0;
        for (ListNode p = head; p != null; p = p.next) {
            length++;
        }
        recursion(head, length);
    }
    private ListNode recursion(ListNode head, int len) {
        if (len == 1) return head;
        else if (len == 2) return head.next;
        ListNode tail = recursion(head.next, len - 2);
        ListNode outTail = tail.next;
        tail.next = tail.next.next;
        outTail.next = head.next;
        head.next = outTail;
        return tail;
    }

    public static void main(String[] args) {

    }
}
