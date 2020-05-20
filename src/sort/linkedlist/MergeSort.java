package sort.linkedlist;

import DS.ListNode;
import tool.Tools;

public class MergeSort {
    public ListNode mergeSort(ListNode head) {
        //终止条件
        if (head == null || head.next == null)
            return head;

        //寻找中点分割
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(temp);

        //归并
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null)
            tail.next = left;
        if (right != null)
            tail.next = right;
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeSort s = new MergeSort();
        ListNode head = Tools.createLinkedlist(new int[]{4,2,1,3,9,0,1,23});
        Tools.printLinkedlist(s.mergeSort(head));
    }
}
