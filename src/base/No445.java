package base;

import java.util.Stack;

public class No445 {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode head = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1, num2;
            num1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            num2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        return head;
    }
}
