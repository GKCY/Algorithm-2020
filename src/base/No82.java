package base;

public class No82 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int pre = head.val;
        int count = 1;
        head = head.next;
        while (head != null) {
            if (head.val == pre)
                count++;
            else if (head.val != pre) {
                if (count == 1) {
                    p.next = new ListNode(pre);
                    p = p.next;
                }
                pre = head.val;
                count = 1;
            }
            head = head.next;
        }
        if (count == 1) {
            p.next = new ListNode(pre);
            p = p.next;
        }
        p.next = null;
        return dummy.next;
    }

    public ListNode solution2(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp.next != null && temp.val == temp.next.val)
                    temp = temp.next;
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            ListNode p = head.next;
            while (true) {
                if (p == null || p.val != head.val)
                    break;
                p = p.next;
            }
            return deleteDuplicates(p);
        }
    }

}
