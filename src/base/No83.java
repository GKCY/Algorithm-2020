package base;

import DS.ListNode;

public class No83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode ptr = head;
        while (ptr != null) {
            if (pre == null) {
                pre = ptr;
                ptr = ptr.next;
            } else {
                if (ptr.val == pre.val) {
                    pre.next = ptr.next;
                    ptr = pre.next;
                } else {
                    pre = ptr;
                    ptr = ptr.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode head = tool.Tools.createLinkedlist(new int[]{1,1,2,2,3});
////        tool.Tools.printLinkedlist(head);
//        No83 t = new No83();
//        t.deleteDuplicates(head);
//        tool.Tools.printLinkedlist(head);
    }
}
