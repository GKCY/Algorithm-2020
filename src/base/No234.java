package base;

import DS.ListNode;
import tool.Tools;

import javax.sound.midi.SoundbankResource;

public class No234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = reverse(slow.next);
        ListNode p1 = half, p2 = head;
        boolean flag = true;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                flag = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        slow.next = reverse(half);
        return flag;

    }
    public ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        while (true) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            if (next == null) break;
            head = next;
        }
        return head;
    }

    public static void main(String[] args) {
        No234 t = new No234();
        int[] nums = {1,2,2,2};
        ListNode head = Tools.createLinkedlist(nums);
        System.out.println(t.isPalindrome(head));
    }

}
