package base;

import DS.ListNode;
import tool.Utils;

public class No328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        boolean isOdd = true;
        ListNode oddTail = odd;
        ListNode evenTail = even;
        while (head != null) {
            ListNode temp = head.next;
            if (isOdd) {
                oddTail.next = head;
                oddTail = oddTail.next;
            } else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            isOdd = !isOdd;
            head = temp;
        }
        oddTail.next = even.next;
        evenTail.next = null;

        return odd.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = Utils.createLinkedlist(nums);
        Utils.printLinkedlist(head);
        Utils.printLinkedlist(new No328().oddEvenList(head));
    }
}
