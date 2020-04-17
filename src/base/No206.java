package base;

public class No206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode headNext;
        while (head!=null){
            headNext = head.next;
            head.next = pre;
            pre = head;
            head = headNext;
        }
        return pre;

    }
}
