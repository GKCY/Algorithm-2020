package base;

import DS.*;


public class No92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        for (int i = 0; i < m-1; i++)
            p1 = p1.next;
        ListNode t1 = p1.next;
        System.out.println("p1:" + p1.val);

        int count = n - m + 1;
        System.out.println("count:" + count);
        ListNode cur = t1;
        ListNode pre = p1;
        ListNode next = t1.next;
        for (int i = 0; i < count; i++) {
            System.out.println("this:" + pre.val);
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }
        p1.next = pre;
        t1.next = cur;
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = null;
//        base.No92 t = new base.No92();
//        t.reverseBetween(head, 2, 4);
//        for (int i = 0; i < 15; i++) {
//            System.out.println(head.val);
//            head = head.next;
//        }
        ListNode head = Tools.createLinkedlist(new int[]{1,2,3,4,5});
        Tools.printLinkedlist(head);
    }

}
